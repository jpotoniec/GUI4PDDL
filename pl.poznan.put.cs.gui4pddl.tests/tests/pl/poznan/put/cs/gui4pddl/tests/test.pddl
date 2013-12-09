(define
	(domain world-of-blocks)
	(:predicates 
		(on-top ?x ?y)
		(on-floor ?x)
		(clear ?x)
	)
	(:requirements :adl)
	(:extends sasd)
	(:requirements :adl :d)
	(:types a b d sdfa sfad - wwwh sdfuh - ( fluent  asdf ) dgs dfsgh)
; przesuń klocek na podłogę
        
        
        
    (:action PUSH-START
  :parameters(
    ;; Pipeline segment that will be moved
    ?pipe - pipe
    ;; Unitary batch that will be inserted into the pipeline
    ;; segment
    ?batch-atom-in - batch-atom
    ?from-area - area
    ?to-area - area
    ?first-batch-atom - batch-atom
    ?product-batch-atom-in - product
    ?product-first-batch - product
  )
  :precondition
   (and
 
   ;; normal planning mode
   (normal ?pipe)
   ;; Binds :vars section
   (first ?first-batch-atom ?pipe)
   (connect ?from-area ?to-area ?pipe)
   ;; Inserted batch must be in 'from-area'
   (on ?batch-atom-in ?from-area)
   ;; Action is applicable only in non-unitary pipeline segments
   (not-unitary ?pipe)
   ;; Bind batch-atom products
   (is-product ?batch-atom-in ?product-batch-atom-in)
   (is-product ?first-batch-atom ?product-first-batch)
   ;; Interface restriction
   (may-interface ?product-batch-atom-in ?product-first-batch)
 
 )
  :effect
   (and
     ;; switch into correct update mode for this pipe
     (push-updating ?pipe)
     (not (normal ?pipe))
     ;; The inserted unitary batch will be the pipeline segment
     ;; new first batch
     (first ?batch-atom-in ?pipe)
     (not (first ?first-batch-atom ?pipe))
 
     ;; Updates the follow and last relationship to the new
     ;; pipeline segment configuration
     (follow ?first-batch-atom ?batch-atom-in)
     ;; Inserted batch-atom is removed from area
     (not (on ?batch-atom-in ?from-area))
    ;; Batch-atom removed from pipeline segment is inserted
    ;; into the destination area
)
)    
        
)