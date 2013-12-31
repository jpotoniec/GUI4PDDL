######################################################################
#
#  Generic Makefile for LaTeX/LyX documents
#  by Cezary Sobaniec <cezary.sobaniec@cs.put.poznan.pl>
#
#  $Id: latex.mk 3119 2012-11-22 09:15:22Z sobaniec $
#
######################################################################


# --------------------------------------------------------------------
#
# Getting started
# ===============
#
# For ease of use define the following function for bash interpreter:
#
#   function mk() {
#     if [ -f Makefile ]
#     then
#       make "$@"
#     else
#       make -f $HOME/share/LaTeX/latex.mk "$@"
#     fi
#   }
#
# Thanks to this function you may run 'mk' command without Makefile.
# Alternatively you can create a Makefile with the following contents:
#
#   include latex.mk
#
# To get help run 'mk help' or 'make help'.
#
# Please update the path to your local copy of 'latex.mk' in variable
# 'MAKE' just below:
#
# --------------------------------------------------------------------

ifneq ($(wildcard Makefile),Makefile)
  MAKE=make -f $(HOME)/share/LaTeX/latex.mk
endif
MAINFILE?=${firstword ${wildcard *.lyx} ${wildcard *.tex}}
ifeq (${MAINFILE},)
$(error Value of MAINFILE unknown.  Missing .lyx or .tex file.)
endif
MF:=$(MAINFILE:.lyx=)
MF:=$(MF:.tex=)

BACKUPFILE=$(shell basename ${PWD}).tar.gz

MONO?=no

PS_VIEWER?=gv -antialias -scale 2 -swap -resize
PDF_VIEWER?=acroread
PDF_VIEWER_OPTS?=
TEX_EDITOR?=gvim -geometry 90x52+370+0
DVI_VIEWER?=kdvi
DVI_VIEWER_OPTS?=
FIG2DEV_OPTS?=
SCALE?=1.1
HTMLOUTDIR?=HTML
PSTOPSOPS?=-pa4
FIGMAG?=1.5
CLEAN_FIGS?=yes
TMPFILE=latex.mk.tmp~
DIRECT_SVG_PDF_CONV?=yes
DPI=600
# pdftex, xetex or luatex
PDFENGINE?=xetex

ifeq (${MONO},yes)
FIG2DEV_OPTS+=-N
endif

LYX_DOC_FILES=${wildcard *.lyx}
TEX_DOC_FILES=${wildcard *.tex}
TXT_DOC_FILES=${wildcard *.txt}
HTML_DOC_FILES=${TXT_DOC_FILES:.txt=.html}
XFIG_PICTURES?=${wildcard *.fig */*.fig}
SVG_PICTURES?=${wildcard *.svg */*.svg}
DIA_PICTURES?=${wildcard *.dia */*.dia}
PNG_PICTURES?=${wildcard *.png */*.png}
GIF_PICTURES?=${wildcard *.gif */*.gif}
JPG_PICTURES?=${wildcard *.jpg */*.jpg}
WMF_PICTURES?=${wildcard *.wmf */*.wmf}
EPS_PICTURES=${wildcard *.eps */*.eps}
PST_PICTURES?=${wildcard *.pst */*.pst}
GPI_PICTURES?=${wildcard *.gpi */*.gpi}
SOURCE_PICTURES=${XFIG_PICTURES} ${SVG_PICTURES} ${DIA_PICTURES} \
	${PNG_PICTURES} ${GIF_PICTURES} ${JPG_PICTURES} ${WMF_PICTURES} \
	${PST_PICTURES} ${GPI_PICTURES}
# pictures generated from sources:
PDF_PICTURES=${wildcard *.pdf */*.pdf}
PDF_PICTURES:=${filter-out ${MF}.pdf,${PDF_PICTURES}}
PDF_GEN_PICTURES=${XFIG_PICTURES:.fig=.pdf} \
	${SVG_PICTURES:.svg=.pdf} \
	${WMF_PICTURES:.wmf=.pdf} \
	${DIA_PICTURES:.dia=.pdf} \
	${PST_PICTURES:.pst=.pdf} \
	${GPI_PICTURES:.gpi=.pdf}
PDF_PICTURES:=${filter-out ${PDF_GEN_PICTURES} ${PNG_PICTURES:.png=.pdf},${PDF_PICTURES}}
PS_PICTURES=${XFIG_PICTURES:.fig=.eps} ${SVG_PICTURES:.svg=.eps} \
	${DIA_PICTURES:.dia=.eps} ${PNG_PICTURES:.png=.eps} \
	${GIF_PICTURES:.gif=.eps} ${JPG_PICTURES:.jpg=.eps} \
	${GPI_PICTURES:.gpi=.eps} ${PST_PICTURES:.pst=.eps}



SKIP="****************************************************************"

ifdef BIBLIO
BIBLIOGRAPHY=${MF}.bbl
endif
ifdef INDEX
INDEXDEP=${MF}.ind
endif

#
# Pattern rules
#

%.pdf: %.fig
	@echo ${SKIP}
	@echo "*  Converting $< to pdf ..."
	@echo ${SKIP}
	fig2dev -L pdf ${FIG2DEV_OPTS} -p x $< > $@

%.eps: %.fig
	@echo ${SKIP}
	@echo "*  Converting $< to eps ..."
	@echo ${SKIP}
	fig2dev -L eps ${FIG2DEV_OPTS} $< > $@

%.eps: %.svg
	@echo ${SKIP}
	@echo "*  Converting $< to eps ..."
	@echo ${SKIP}
	@inkscape -d ${DPI} -T -E $@ $< 2> /dev/null

%.pdf: %.svg
	@echo ${SKIP}
	@echo "*  Converting $< to pdf ..."
	@echo ${SKIP}
	@if [ "${DIRECT_SVG_PDF_CONV}" = "yes" ]; then \
	  inkscape -d ${DPI} -T -A $@ $< 2> /dev/null; \
	else \
	  ${MAKE} --no-print-directory $*.eps; \
	  epstopdf $*.eps; \
	fi

%.eps: %.gif
	@echo ${SKIP}
	@echo "*  Please convert GIF pictures to PNG format"
	@echo ${SKIP}
	exit 1

%.eps: %.png
	@echo ${SKIP}
	@echo "*  Converting $< to $@ ..."
	@echo ${SKIP}
	@if [ "${MONO}" = "yes" ]; then \
	  pngtopnm $< | ppmtopgm | pnmtops -noturn > $@; \
	else \
	  pngtopnm $< | pnmtops -noturn > $@; \
	fi

%.png: %.fig
	@echo ${SKIP}
	@echo "*  Running fig2dev for $< ..."
	@echo ${SKIP}
	fig2dev -L png ${FIG2DEV_OPTS} -m ${FIGMAG} $< $@

%.gif: %.fig
	@echo ${SKIP}
	@echo "*  Running fig2dev for $< ..."
	@echo ${SKIP}
	fig2dev -L gif ${FIG2DEV_OPTS} -m ${FIGMAG} $< $@

%.jpg: %.fig
	@echo ${SKIP}
	@echo "*  Running fig2dev for $< ..."
	@echo ${SKIP}
	fig2dev -L jpeg ${FIG2DEV_OPTS} -m ${FIGMAG} $< $@

%.pdf: %.pst
	@echo ${SKIP}
	@echo "* Running LaTeX for $< ... $@"
	@echo ${SKIP}
	@latex --output-directory=$(dir $<) $<
	@dvips $*.dvi -o - | ps2pdf - $@
	@rm -f $*.{aux,dvi,log}
	@pdfcrop $@ $(dir $<)/tmp.pdf
	@mv $(dir $<)/tmp.pdf $@

%.eps: %.pst
	@echo ${SKIP}
	@echo "* Running LaTeX for $< ... $@"
	@echo ${SKIP}
	@latex --output-directory=$(dir $<) $<
	@dvips -E $*.dvi -o $@
	@rm -f $*.{aux,dvi,log}

%.pdf: %.gpi
	@echo ${SKIP}
	@echo "* Running GnuPlot $< ... $@"
	@echo ${SKIP}
	@gnuplot $< | ps2pdf - $@
	@pdfcrop $@ $(dir $<)/tmp.pdf
	@mv $(dir $<)/tmp.pdf $@

%.eps: %.gpi
	@echo ${SKIP}
	@echo "* Running GnuPlot $< ... $@"
	@echo ${SKIP}
	@gnuplot $< > $@

%.dvi: %.tex
	@echo ${SKIP}
	@echo "*  Running LaTeX for $< ... "
	@echo ${SKIP}
	-test -f $*.aux && cp $*.aux $*.aux~
	@latex $<

%.pdf: %.tex
	@echo ${SKIP}
	@echo "*  Running PDFLaTeX for $< ..."
	@echo ${SKIP}
	-test -f $*.aux && cp $*.aux $*.aux~
	@if [ "${PDFENGINE}" = "xetex" ]; then \
	  xelatex $<; \
	 elif [ "${PDFENGINE}" = "luatex" ]; then \
	  lualatex $<; \
	 else \
	  pdflatex $<; \
	 fi

%.ps: %.dvi
	@echo ${SKIP}
	@echo "*  Running dvips for $< ..."
	@echo ${SKIP}
	@if grep -q '\\geometry{.*landscape' $*.tex; then \
	   dvips -t landscape -o $@ $<; \
	 else \
	   dvips ${DVIPSOPS} $< -o $@; \
	 fi

%.tex: %.lyx
	@echo ${SKIP}
	@echo "*  Exporting file $< to LaTeX ..."
	@echo ${SKIP}
	@if [ "${PDFENGINE}" = "xetex" ]; then \
	  lyx -e xetex $<; \
	 elif [ "${PDFENGINE}" = "luatex" ]; then \
	  lyx -e luatex $<; \
	 else \
	  lyx -e latex $<; \
	 fi
	@rm -f ${PDF_GEN_PICTURES:.pdf=.eps}

%.eps: %.dia
	@echo ${SKIP}
	@echo "*  Converting $< to eps ..."
	@echo ${SKIP}
	@dia -t eps -O $(dir $<) $<

%.eps: %.wmf
	@echo ${SKIP}
	@echo "*  Converting $< to eps ..."
	@echo ${SKIP}
	@wmf2eps $*.wmf > $@

%.pdf: %.eps
	epstopdf $<


# for reStructuredText
%.html: %.txt
	@echo ${SKIP}
	@echo "*  Converting $< to HTML ..."
	@echo ${SKIP}
	@rst2html $*.txt > $@


#
#  Targets
#

all: finalpdf

build: clean final

dvi: ${MF}.dvi

view: all viewpdf

viewdvi: ${MF}.dvi
	@${DVI_VIEWER} ${DVI_VIEWER_OPTS} ${MF}.dvi &

viewps: ${MF}.ps
	@echo ${SKIP}
	@echo "*  Running PS viewer ..."
	@echo ${SKIP}
	@${PS_VIEWER} ${MF}.ps &

viewfinal: final view

viewfinalps: final viewps

viewfinalpdf: final viewpdf

clean: pclean mclean

pclean:
	@rm -f core *.dvi *.aux *.log *.[Bb][Aa][Kk] *.bbl *.blg \
	       *.toc *.lof *.lot \
	       *.bck *.idx *.ind *.ilg *.swp SAVE.fig *~ ~* *.nlo \
	       svn-history.tex \
	       *.nav *.snm *.synctex \
	       *.ps \#*\# *.out *.tmp \
	       WARNINGS label.pl \
	       ${MF}.ps.gz \
	       ${BACKUPFILE} ${PS_PICTURES} \
	       ${XFIG_PICTURES:.fig=.pdf} ${XFIG_PICTURES:.fig=.eps} \
	       ${DIA_PICTURES:.dia=.pdf} ${DIA_PICTURES:.dia=.eps} \
	       ${SVG_PICTURES:.svg=.pdf} ${SVG_PICTURES:.svg=.eps} \
	       ${PST_PICTURES:.pst=.pdf} \
	       ${PST_PICTURES:.pst=.aux} \
	       ${PST_PICTURES:.pst=.log} \
	       ${PST_PICTURES:.pst=.dvi} \
	       ${GPI_PICTURES:.gpi=.pdf} \
	       ${PDF_PICTURES:.pdf=.eps} \
	       ${LYX_DOC_FILES:.lyx=.tex} ${LYX_DOC_FILES:.lyx=.txt} \
	       ${TEX_DOC_FILES:.tex=.txt} \
	       ${HTML_DOC_FILES} ui
	@rm -rf ${HTMLOUTDIR} ${MF}

mclean:
	@rm -f -- ${LYX_DOC_FILES:.lyx=.pdf} ${LYX_DOC_FILES:.lyx=-*x*.pdf} \
	       ${LYX_DOC_FILES:.lyx=.ps} \
	       ${TEX_DOC_FILES:.tex=.pdf} ${TEX_DOC_FILES:.tex=.ps}

clean-figs:
	@rm -f ${PS_PICTURES} ${XFIG_PICTURES:.fig=.pdf} ${XFIG_PICTURES:.fig=.png}

figs: pdffigs

psfigs:	${PS_PICTURES}

pdffigs: ${PDF_GEN_PICTURES}

backup:
	@echo ${SKIP}
	@echo "*  Creating backup ... "
	@echo ${SKIP}
	@rm -f ${BACKUPFILE}
	@-tar cvfz ${BACKUPFILE} \
	           *.tex *.lyx *.fig *.dia *.inc *.gif *.png *.jpg *.txt \
	           *.bib Makefile *.sty *.cls ${BACKUPINC} *.eps 2> /dev/null

bib: figs export ${MF}.bbl

${MF}.bbl: ${BIBLIO}
	@if [ ! -r ${MF}.aux ]; then \
	  echo ${SKIP}; \
	  echo "*  Running latex before BibTeX for ${MF} ..."; \
	  echo ${SKIP}; \
	  if [ "${PDFENGINE}" = "xetex" ]; then \
	    xelatex ${MF}.tex; \
	   elif [ "${PDFENGINE}" = "luatex" ]; then \
	    lualatex ${MF}.tex; \
	   else \
	    pdflatex ${MF}.tex; \
	   fi; \
	  fi
	@echo ${SKIP}
	@echo "*  Running BibTeX for ${MF} ..."
	@echo ${SKIP}
	@bibtex ${MF}

${MF}.ind: ${MF}.tex
	@if [ ! -r ${MF}.idx ]; then \
	  echo ${SKIP}; \
	  echo "*  Running latex before Makeindex for ${MF} ..."; \
	  echo ${SKIP}; \
	  if [ "${PDFENGINE}" = "xetex" ]; then \
	    xelatex ${MF}.tex; \
	   elif [ "${PDFENGINE}" = "luatex" ]; then \
	    lualatex ${MF}.tex; \
	   else \
	    pdflatex ${MF}.tex; \
	   fi; \
	fi
	@echo ${SKIP}
	@echo "*  Running Makeindex for ${MF} ..."
	@echo ${SKIP}
	@makeindex ${MF}

${MF}.dvi: ${MF}.tex ${INCLUDES} ${PS_PICTURES} ${BIBLIOGRAPHY} ${INDEXDEP}

ps: ${MF}.ps

${MF}.ps: ${MF}.dvi

pdf: ${MF}.pdf

${MF}.pdf: ${MF}.tex ${INCLUDES} ${PDF_GEN_PICTURES} ${BIBLIOGRAPHY} ${INDEXDEP}

viewpdf: ${MF}.pdf
	${PDF_VIEWER} ${PDF_VIEWER_OPTS} ${MF}.pdf &

final: finalpdf

finaldvi:
	@rm -f ${MF}.dvi
	@${MAKE} dvi
	@if [ -f "${MF}.idx" ]; then \
	  ${MAKE} ${MF}.ind; \
	fi
	@if grep -q '\\bibdata{' ${MF}.aux; then \
	  ${MAKE} bib; \
	  rm -f ${MF}.dvi; \
	  ${MAKE} dvi; \
	fi
	@if ! cmp -s ${MF}.aux ${MF}.aux~; then \
	  rm -f ${MF}.dvi; \
	  ${MAKE} dvi; \
	  if ! cmp -s ${MF}.aux ${MF}.aux~; then \
	    rm -f ${MF}.dvi; \
	    ${MAKE} dvi; \
	  fi; \
	fi

finalps: finaldvi ps

finalpdf:
	@rm -f ${MF}.pdf
	@${MAKE} pdf
	@if [ -f "${MF}.idx" ]; then \
	  ${MAKE} ${MF}.ind; \
	fi
	@if [ -f "${MF}.aux" ]; then \
	  ${MAKE} bib; \
	  rm -f ${MF}.pdf; \
	  ${MAKE} pdf; \
	fi
	@if ! cmp -s ${MF}.aux ${MF}.aux~; then \
	  rm -f ${MF}.pdf; \
	  ${MAKE} pdf; \
	  if ! cmp -s ${MF}.aux ${MF}.aux~; then \
	    rm -f ${MF}.pdf; \
	    ${MAKE} pdf; \
	  fi; \
	fi

4perpage:
	@echo ${SKIP}
	@echo "*  Dividing into 4 pages per A4 page ..."
	@echo ${SKIP}
	@if grep -q '\\geometry{.*landscape' ${MF}.tex; then \
	  pstops ${PSTOPSOPS} '4:2@.5(0,14.85cm)+0@.5(10.5cm,14.85cm)+3@.5(0,0)+1@.5(10.5cm,0)' ${MF}.ps ${TMPFILE}; \
	else \
	  pstops ${PSTOPSOPS} '4:0@.5(0,14.85cm)+1@.5(10.5cm,14.85cm)+2@.5(0,0)+3@.5(10.5cm,0)' ${MF}.ps ${TMPFILE}; \
	fi
	mv ${TMPFILE} ${MF}.ps

4perpagelandscape:
	@echo ${SKIP}
	@echo "*  Dividing into 4 pages per A4 page ..."
	@echo ${SKIP}
	pstops ${PSTOPSOPS} '4:0U@.5(10.5cm,14.85cm)+1U@.5(10.5cm,29.7cm)+2U@.5(21cm,14.85cm)+3U@.5(21cm,29.7cm)' ${MF}.ps ${TMPFILE}
	mv ${TMPFILE} ${MF}.ps

book:
	@echo ${SKIP}
	@echo "*  Dividing into 2 pages per A4 page in a book style ..."
	@echo ${SKIP}
	@mv ${MF}.ps ${TMPFILE}
	pstops ${PSTOPSOPS} '4:1L@.7(21cm,0cm)+2L@.7(21cm,14.85cm),3L@.7(21cm,0cm)+0L@.7(21cm,14.85cm)' ${TMPFILE} ${MF}.ps
	@rm -f ${TMPFILE}

booksimple:
	@echo ${SKIP}
	@echo "*  Dividing into 2 pages per A4 page in a simple book style ..."
	@echo ${SKIP}
	mv ${MF}.ps ${TMPFILE}
	psbook ${TMPFILE} | psnup -PA4 -2 > ${MF}.ps
	rm -f ${TMPFILE}

2perpage:
	@echo ${SKIP}
	@echo "*  Dividing into 2 pages per A4 page ..."
	@echo ${SKIP}
	pdfnup -q --nup 2x1 --paper a4paper ${MF}.pdf

2perpageps:
	@echo ${SKIP}
	@echo "*  Dividing into 2 pages per A4 page ..."
	@echo ${SKIP}
	mv ${MF}.ps ${TMPFILE}
	pstops ${PSTOPSOPS} '2:0L@.7(21cm,0cm)+1L@.7(21cm,14.85cm)' ${TMPFILE} ${MF}.ps
	rm -f ${TMPFILE}

2perpagethesame:
	@echo ${SKIP}
	@echo "*  Dividing into 2 the same pages per A4 page ..."
	@echo ${SKIP}
	mv ${MF}.ps ${TMPFILE}
	pstops ${PSTOPSOPS} '1:0L@.7(21cm,0cm)+0L@.7(21cm,14.85cm)' ${TMPFILE} ${MF}.ps
	rm -f ${TMPFILE}

2perpagerotate:
	@echo ${SKIP}
	@echo "*  Combining into 2 pages per A4 page ..."
	@echo ${SKIP}
	@mv ${MF}.ps ${TMPFILE}
	pstops ${PSTOPSOPS} '4:0+2U(210mm,297mm),1+3U(210mm,297mm)' ${TMPFILE} ${MF}.ps
	@rm -f ${TMPFILE}

a5book:
	@echo ${SKIP}
	@echo "*  Combining into 2 pages per A4 page ..."
	@echo ${SKIP}
	@mv ${MF}.ps ${TMPFILE}
	@psbook ${TMPFILE} ${MF}.ps
	@mv ${MF}.ps ${TMPFILE}
	pstops ${PSTOPSOPS} '2:0L(297mm,0)+1L(297mm,148.5mm)' ${TMPFILE} ${MF}.ps
	@rm -f ${TMPFILE}

2perpageoverlapthesame:
	@echo ${SKIP}
	@echo "*  Combining into 2 pages per A4 page ..."
	@echo ${SKIP}
	@mv ${MF}.ps ${TMPFILE}
	@pstops ${PSTOPSOPS} '1:0+0(0,-14.85cm)' ${TMPFILE} ${MF}.ps
	@rm -f ${TMPFILE}

2perpageoverlap:
	@echo ${SKIP}
	@echo "*  Combining into 2 pages per A4 page ..."
	@echo ${SKIP}
	@mv ${MF}.ps ${TMPFILE}
	@pstops ${PSTOPSOPS} '2:0+1(0,-14.85cm)' ${TMPFILE} ${MF}.ps

4perpageoverlapthesame:
	@echo ${SKIP}
	@echo "*  Combining into 2 pages per A4 page ..."
	@echo ${SKIP}
	@mv ${MF}.ps ${TMPFILE}
	@pstops ${PSTOPSOPS} '1:0L@.7(21cm,14.85cm)+0L@.7(31.5cm,14.85cm)+0L@.7(21cm,0cm)+0L@.7(31.5cm,0cm)' ${TMPFILE} ${MF}.ps
	@rm -f ${TMPFILE}

refcard: finalps
	@echo ${SKIP}
	@echo "*  Compiling a refcard"
	@echo ${SKIP}
	pstops -pa3 '3:0+1(0cm,-140mm)+2(0cm,-280mm)' ${MF}.ps ${TMPFILE}
	psresize -Pa3 -pa4 ${TMPFILE} ${MF}.ps
	@rm -f ${TMPFILE}

scale:
	pdfnup -q --nup 1x1 --paper a4paper --no-landscape --scale ${SCALE} ${MF}.pdf
	@mv ${MF}-nup.pdf ${MF}.pdf

scale2:
	pdfnup -q --nup 1x1 --paper a4paper --no-landscape --scale 1.2 ${MF}.pdf
	@mv ${MF}-nup.pdf ${MF}.pdf

edit:
	@if [ ! -f "${MF}.lyx" -a -f "${MF}.tex" ]; then \
	   ${TEX_EDITOR} ${MF}.tex; \
	 else \
	   lyx ${MF}.lyx 2> /dev/null & \
	 fi;

wc: export
	@detex ${MF}.tex | wc -w

export: ${MF}.tex

reexport:
	@rm -f ${MF}.tex
	@${MAKE} export

exportps:
	@echo ${SKIP}
	@echo "*  Exporting file ${MF} to PostScript ..."
	@echo ${SKIP}
	lyx -e ps ${MF}.lyx

exportpdf:
	@echo ${SKIP}
	@echo "*  Exporting file ${MF} to PDF ..."
	@echo ${SKIP}
	lyx -e pdf2 ${MF}.lyx

exporttxt:
	@echo ${SKIP}
	@echo "*  Exporting file ${MF} to TXT ..."
	@echo ${SKIP}
	lyx -e text ${MF}.lyx

install:
	rsync -va ${MF}.pdf ${DESTURL}

historypdf: historyconvert history finalpdf
	@echo "Creating pdf with history ..."

history:
	@touch svn-history.tex
	@-gen-svn-latex-history.sh ${MF}.lyx svn-history.tex

historyconvert: export
	@echo ${SKIP}
	@echo "*  Converting to history ..."
	@echo ${SKIP}
	@sed 's/^\\documentclass\[\(.*\)\]{soaarticle}$$/\\documentclass[history,\1]{soaarticle}/' ${MF}.tex > ${MF}.tmp
	@mv ${MF}.tmp ${MF}.tex

handout: handoutconvert finalpdf
	@echo ${SKIP}
	@echo "*  Dividing into 4 pages per A4 page ..."
	@echo ${SKIP}
	pdfnup -q --nup 2x2 --suffix 2x2 --paper a4paper --frame true --scale 0.92 \
	       --delta "2mm 2mm" ${MF}.pdf
	@chmod +r ${MF}-2x2.pdf

ho: handout

handoutinstall:
	rsync -va ${MF}-2x2.pdf ${DESTURL}

hi: handoutinstall

handoutconvert: export
	@echo ${SKIP}
	@echo "*  Converting to handout ..."
	@echo ${SKIP}
	@sed 's/^\\documentclass\[\(.*\)\]{beamer}$$/\\documentclass[handout,\1]{beamer}/' ${MF}.tex > ${MF}.tmp
	@mv ${MF}.tmp ${MF}.tex

color-oneside: clean export
	@sed 's/\\documentclass\[\(.*\)\]{\(.*\)}/\\documentclass[\1,web]{\2}/' \
	      ${MF}.tex > ${MF}-oneside.tex
	@mv ${MF}-oneside.tex ${MF}.tex
	@${MAKE} -s finalpdf

color-twoside: clean export
	@sed 's/\\documentclass\[\(.*\)\]{\(.*\)}/\\documentclass[\1,webtwoside]{\2}/' \
	      ${MF}.tex > ${MF}-oneside.tex
	@mv ${MF}-oneside.tex ${MF}.tex
	@${MAKE} -s finalpdf

mono: clean export
	@${MAKE} -s MONO=yes clean-figs pdffigs
	@${MAKE} -s finalpdf

mono-oneside: clean export
	@${MAKE} -s MONO=yes clean-figs pdffigs
	@sed 's/\\documentclass\[\(.*\)\]{\(.*\)}/\\documentclass[\1,oneside]{\2}/' \
	      ${MF}.tex > ${MF}-oneside.tex
	@mv ${MF}-oneside.tex ${MF}.tex
	@${MAKE} -s finalpdf

html: export
	@rm -rf ${MF}
	@latex2html -html_version 4.0,unicode -split 0 -nonavigation -noinfo \
	           -noaddress ${MF}.tex

help:
	@echo "Makefile for LaTeX/LyX documents"
	@echo
	@echo "Available targets:"
	@echo
	@echo "  all            compile PDF output (default)"
	@echo "  history        generate history of changes (svn-history.tex)"
	@echo "  historypdf     compile PDF output with history of changes"
	@echo "  ps             compile PostScript output"
	@echo "  dvi            compile DVI output"
	@echo "  final          compile final PDF output"
	@echo "  finalps        compile final PostScript output"
	@echo "  finaldvi       compile final DVI output"
	@echo "  figs,pdffigs   compile/convert figures for PDF output"
	@echo "  psfigs         compile/convert figures for PS output"
	@echo "  clean          clean the directory"
	@echo "  pclean         clean the directory excluding PDF output"
	@echo "  edit           start LyX editor for the main file"
	@echo "  export         export LyX document to LaTeX file"
	@echo "  exportpdf      export LyX document to PDF format (by LyX)"
	@echo "  exportps       export LyX document to PostScript format (by LyX)"
	@echo "  exporttxt      export LyX document to TXT format (by LyX)"
	@echo "  backup         create a backup"
	@echo "  bib            run BiBTeX for the document"
	@echo "  view           run PDF viewer"
	@echo "  viewps         run PostScript viewer"
	@echo "  viewdvi        run DVI viewer"
	@echo "  viewfinal      run viewer on final PDF output"
	@echo "  viewfinalps    run viewer on final PostScript output"
	@echo "  wc             calculate number of words in the document"
	@echo ""
