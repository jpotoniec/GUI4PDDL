(define (domain pipesworld_strips)

(:requirements :strips :typing )

;; Types
;;  pipe: a pipeline segment
;;  area: operational areas
;;  product: an oil derivative product, such as gasoline,
;;    kerosene, etc.
;;  batch-atom: an unitary batch
(:constants lco gasoleo rat-a oca1 oc1b - product )

(:predicates
 
  (unitary ?pipe - pipe)
  (not-unitary ?pipe)
  (is-product ?batch-atom - batch-atom ?product - product)

)
(:action PUSH-START
  :parameters(
    ?pipe - pipe
    ?batch-atom-in - batch-atom
    ?from-area - area
    ?to-area - area
    ?first-batch-atom - batch-atom
    ?product-batch-atom-in - product
    ?product-first-batch - product
  )
  :precondition
   (and
   (normal ?pipe)
   (first ?first-batch-atom ?pipe)
   (connect ?from-area ?to-area ?pipe)
   (on ?batch-atom-in ?from-area)
   (not-unitary ?pipe)
   (is-product ?batch-atom-in ?product-batch-atom-in)
   (is-product ?first-batch-atom ?product-first-batch)
   (may-interface ?product-batch-atom-in ?product-first-batch)

 )
  :effect
   (and 
     (push-updating ?pipe)
     (not (normal ?pipe))
     (first ?batch-atom-in ?pipe)
     (not (first ?first-batch-atom ?pipe))
     (follow ?first-batch-atom ?batch-atom-in)
     (not (on ?batch-atom-in ?from-area))

)
)

(:action POP-END
  :parameters(
    ?pipe - pipe
    ?from-area - area
    ?to-area - area
    ?first-batch-atom - batch-atom
    ?next-first-batch-atom - batch-atom
  )
  :precondition
   (and
   (pop-updating ?pipe)
   (first ?first-batch-atom ?pipe)
   (connect ?from-area ?to-area ?pipe)
   (not-unitary ?pipe)
   (follow ?next-first-batch-atom ?first-batch-atom)

 )
  :effect
   (and 
     (not (pop-updating ?pipe))
     (normal ?pipe)

     (not (follow ?next-first-batch-atom ?first-batch-atom))
     (first ?next-first-batch-atom ?pipe)
     (not (first ?first-batch-atom ?pipe))
     (on ?first-batch-atom ?from-area)
)
)

)
