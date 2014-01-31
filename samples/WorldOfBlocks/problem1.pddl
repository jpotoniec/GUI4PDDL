(define (problem p1)
	(:requirements :action-expansions)
	(:domain world-of-blocks)
	(:objects a b c)
	(:init
		(clear c)
		(on-top c b) 
		(on-top b a)
		(on-floor a)
	)
	(:goal
		(and
			(clear a przyklad)  
			(on-top a b)
			(on-top b c)
			(on-floor c)
		)
	)
) 
