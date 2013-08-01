(define (problem get-paid)
(:domain briefcase-world)
(:situation briefcase-init)
(:init (at B home) (at P home) (at D home) (in P))
(:goal (and (at B office) (at D office) (at P home))))

