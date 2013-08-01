(define (problem transport-beans)
(:domain transport)
(:situation standard-network)
(:init (beans beans27)
(at beans27 chicago))
(:expansion (constrained (tag (carry-in-train
beans27 chicago newyork)
(> end))
(in-context end
:precondition (not (spoiled beans27))))))

