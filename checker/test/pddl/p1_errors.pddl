(define (problem p1)
	(:domains world-of-blocks)
	(:objects a b c)
	(:inita
		(clear c)
		(on-top c b)
		(on-top b a)
		(on-floor a)
	)
	(:goal
		(and
			(clear a)
			(on-top a b)
			(on-top b c)
			(on-floor c)
		)
	)




