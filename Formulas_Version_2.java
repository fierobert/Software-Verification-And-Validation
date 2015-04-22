//@author Jesus Tabares
	
	/*
	  At Least Once C for L, P, Q, and R

	  LTL description: p1 | ... | pn

	*/
	
	String L_AtLeastOne_C = "(l1|l2|l3) .";//l1l2|l3
	String P_AtLeastOne_C = "(p1|p2|p3) .";////p1|p2|p3
	String Q_AtLeastOne_C = "(q1|q2|q3) .";//p1|p2|p3
	String R_AtLeastOne_C = "(r1|r2|r3) .";//p1|p2|p3

	/*
	  At Least Once E for L, P, Q, and R

	  LTL description: (! p1 ^ ...^ ! pn) ^ ((! p1 ^ ...^ ! pn) U (p1 | ...| pn))

	*/

	String L_AtLeastOneE = "((!l1&!l2&!l3) .)&(((!l1&!l2&!l3) .) U (((l1|l2|l3) .)))";//(!l1^!l2^!l3)^((!l1^!l2^!l3)U(l1|l2|l3))
	String P_AtLeastOneE = "((!p1&!p2&!p3) .)&(((!p1&!p2&!p3) .) U (((p1|p2|p3). )))";//(!p1^!p2^!p3)^((!p1^!p2^!p3)U(p1|p2|p3))
	String Q_AtLeastOneE = "((!q1&!q2&!q3) .)&(((!q1&!q2&!q3) .) U (((q1|q2|q3) .)))";//(!q1^!q2^!q3)^((!q1^!q2^!q3)U(q1|q2|q3))
	

	/*
	  Parallel C for L, P, Q, and R

	  LTL description: p1 ^ ... ^ pn	

	*/

	String L_ParallelC = "(l1&l2&l3) .";//l1^l2^l3
	String P_ParallelC = "(p1&p2&p3) .";//p1^p2^p3
	String Q_ParallelC = "(q1&q2&q3) .";//q1^q2^q3
	String R_ParallelC = "(r1&r2&r3) .";//r1^r2^r3

	/*
	  Parallel E for L, P, and Q

	  LTL description: (! p1 ^...^ ! pn) ^ ((! p1 ^...^ ! pn) U (p1 ^...^ pn))

	*/

	String L_AtLeastOneE = "(((!l1&!l2&!l3) .)&(((!l1&!l2&!l3) .) U ((l1&l2&l3) .)))";//(!l1^!l2^!l3)^((!l1^!l2^!l3)U(l1^l2^l3))
	String P_AtLeastOneE = "(((!p1&!p2&!p3) .)&(((!p1&!p2&!p3) .) U ((p1&p2&p3) .)))";//(!p1^!p2^!p3)^((!p1^!p2^!p3)U(p1^p2^p3))
	String Q_AtLeastOneE = "(((!q1&!q2&!q3) .)&(((!q1&!q2&!q3) .) U ((q1&q2&q3) .)))";//(!q1^!q2^!q3)^((!q1^!q2^!q3)U(q1^q2^q3))


	/*
	  Consecutive C for L, P, Q, and R

	  LTL description: (p1^X(p2^(...(^ Xpn))...))

	*/

	String L_ConsecutiveC = "((l1 .)& X((l2 .)(&X(l3 .))))";//(l1^X(l2^Xl3)))
	String P_ConsecutiveC = "((p1 .)& X((p2 .)(&X(p3 .))))";//(p1^X(p2^Xp3)))
	String Q_ConsecutiveC = "((q1 .)& X((q2 .)(&X(q3 .))))";//(q1^X(q2^Xq3)))
	String R_ConsecutiveC = "((r1 .)& X((r2 .)(&X(r3 .))))";//(r1^X(r2^Xr3)))

	/*
	  Consecutive E for L, P, and Q

	 LTL description: (! p1 ^ ...^ ! pn) ^ ((! p1 ^ ...^ ! pn) U 
	                  (p1 ^ ! p2 ^ ...^ ! pn ^ X(p2 ^ ! p3 ^ ...^ ! pn ^ X(...^ X(pn-1 ^ ! pn ^ Xpn))...)))

	*/

	//(!l1^!l2^!l3)^((!l1^!l2^!l3)U(l1^!l2^!l3^X(l2^!l3^X(l2^!l3^Xl3))))
	String L_ConsecutiveE = "(((!l1&!l2&!l3) .)&(((!l1&!l2&!l3) .) U (((l1&!l2&!l3) .)& X(((l2&!l3) .)& (X(l3 .))))))";
	//(!p1^!p2^!p3)^((!p1^!p2^!p3)U(p1^!p2^!p3^X(p2^!p3^X(p2^!p3^Xp3))))
	String P_ConsecutiveE = "(((!p1&!p2&!p3) .)&(((!p1&!p2&!p3) .) U (((p1&!p2&!p3) .)& X(((p2&!p3) .)& (X(p3 .))))))";
	//(!q1^!q2^!q3)^((!q1^!q2^!q3)U(q1^!q2^!q3^X(q2^!q3^X(q2^!q3^Xq3))))
	String Q_ConsecutiveE = "(((!q1&!q2&!q3) .)&(((!q1&!q2&!q3) .) U (((q1&!q2&!q3) .)& X(((q2&!q3) .)& (X(q3 .))))))";


	/*
	  Eventual C for L, P, Q, and R

	  LTL description: (p1 ^ X(! p2 U (p2 ^ X(... ^ X(!pn-1 U (pn-1 ^ X(!pn U pn))))...)))

	*/

    String L_EventualC = "((l1 .)& X((!l2 .)U ((l2 .)& X((!l3 .)U (l3 .)))))";//(l1^X(!l2 U (l2 ^ X (!l2 U (!l3 U l3)))))	
	String P_EventualC = "((p1 .)& X((!p2 .)U ((p2 .)& X((!p3 .)U (p3 .)))))";//(p1^X(!p2 U (p2 ^ X (!p2 U (!p3 U p3)))))
	String Q_EventualC = "((q1 .)& X((!q2 .)U ((q2 .)& X((!q3 .)U (q3 .)))))";//(q1^X(!q2 U (q2 ^ X (!q2 U (!q3 U q3)))))
	String R_EventualC = "((r1 .)& X((!r2 .)U ((r2 .)& X((!r3 .)U (r3 .)))))";//(r1^X(!r2 U (r2 ^ X (!r2 U (!r3 U r3)))))	
	
	/*
	  Eventual E for L, P and Q

	  LTL description: (!p1...^!pn)^((!p1^...^!pn)U(p1^!p2^...^!pn^((!p2^...^!pn)U(p2^!p3^...^!pn^(...^(pn-1^!pn^(!pnUpn))...)))))

	*/
	
	//(!l1^!l2^!l3)^((!l1^!l2^!l3)U(l1^!l2^!l3^((!l2^!l3)U(l2^!l3^(l2^!^!l3^(!l3Ul3))))))
	String L_EventualE = "(((!l1&!l2&!l3).)&(((!l1&!l2&!l3).) U (((l1&!l2&!l3) .)&(((!l2&!l3).) U (((l2&!l3) .)&((!l3 .) U (l3 .)))))))";
	
	//(!p1^!p2^!p3)^((!p1^!p2^!p3)U(p1^!p2^!p3^((!p2^!p3)U(p2^!p3^(p2^!^!p3^(!p3Up3))))))
	String P_EventualE = "(((!p1&!p2&!p3).)&(((!p1&!p2&!p3).) U (((p1&!p2&!p3) .)&(((!p2&!p3).) U (((p2&!p3) .)&((!p3 .) U (p3 .)))))))";

	//(!q1^!q2^!q3)^((!q1^!q2^!q3)U(q1^!q2^!q3^((!q2^!q3)U(q2^!q3^(q2^!^!q3^(!q3Uq3))))))
	String Q_EventualE = "(((!q1&!q2&!q3).)&(((!q1&!q2&!q3).) U (((q1&!q2&!q3) .)&(((!q2&!q3).) U (((q2&!q3) .)&((!q3 .) U (q3 .)))))))";
