//@author Jesus Tabares
	
public class Formulas_Version_3{
	
	public String getLTL(String requestedLTL){
		String returnLTL;
		switch (requestedLTL){
			/*
			  At Least Once C for L, P, Q, and R
	
			  LTL description: p1 | ... | pn
	
			*/
			case "L_AtLeastOneC": 
				returnLTL = "(l1|l2|l3) .";//l1l2|l3
				break;
			case "P_AtLeastOneC": 
				returnLTL = "(p1|p2|p3) .";////p1|p2|p3
				break;
			case "Q_AtLeastOneC": 
				returnLTL = "(q1|q2|q3) .";//p1|p2|p3
				break;
			case "R_AtLeastOneC": 
				returnLTL = "(r1|r2|r3) .";//p1|p2|p3
				break;
	
			/*
			  At Least Once E for L, P, Q, and R
	
			  LTL description: (! p1 ^ ...^ ! pn) ^ ((! p1 ^ ...^ ! pn) U (p1 | ...| pn))
	
			*/
	
			case "L_AtLeastOneE":
				returnLTL = "((!l1&!l2&!l3) .)&(((!l1&!l2&!l3) .) U (((l1|l2|l3) .)))";//(!l1^!l2^!l3)^((!l1^!l2^!l3)U(l1|l2|l3))
				break;
			case "P_AtLeastOneE":
				returnLTL = "((!p1&!p2&!p3) .)&(((!p1&!p2&!p3) .) U (((p1|p2|p3). )))";//(!p1^!p2^!p3)^((!p1^!p2^!p3)U(p1|p2|p3))
				break;
			case "Q_AtLeastOneE":
				returnLTL = "((!q1&!q2&!q3) .)&(((!q1&!q2&!q3) .) U (((q1|q2|q3) .)))";//(!q1^!q2^!q3)^((!q1^!q2^!q3)U(q1|q2|q3))
				break;
			
	
			/*
			  Parallel C for L, P, Q, and R
	
			  LTL description: p1 ^ ... ^ pn	
	
			*/
	
			case "L_ParallelC":
				returnLTL = "(l1&l2&l3) .";//l1^l2^l3
				break;
			case "P_ParallelC":
				returnLTL = "(p1&p2&p3) .";//p1^p2^p3
				break;
			case "Q_ParallelC":
				returnLTL = "(q1&q2&q3) .";//q1^q2^q3
				break;
			case "R_ParallelC":
				returnLTL = "(r1&r2&r3) .";//r1^r2^r3
				break;
	
			/*
			  Parallel E for L, P, and Q
	
			  LTL description: (! p1 ^...^ ! pn) ^ ((! p1 ^...^ ! pn) U (p1 ^...^ pn))
	
			*/
	
			case "L_ParallelE":
				returnLTL = "(((!l1&!l2&!l3) .)&(((!l1&!l2&!l3) .) U ((l1&l2&l3) .)))";//(!l1^!l2^!l3)^((!l1^!l2^!l3)U(l1^l2^l3))
				break;
			case "P_ParallelE":
				returnLTL = "(((!p1&!p2&!p3) .)&(((!p1&!p2&!p3) .) U ((p1&p2&p3) .)))";//(!p1^!p2^!p3)^((!p1^!p2^!p3)U(p1^p2^p3))
				break;
			case "Q_ParallelE":
				returnLTL = "(((!q1&!q2&!q3) .)&(((!q1&!q2&!q3) .) U ((q1&q2&q3) .)))";//(!q1^!q2^!q3)^((!q1^!q2^!q3)U(q1^q2^q3))
				break;
	
	
			/*
			  Consecutive C for L, P, Q, and R
	
			  LTL description: (p1^X(p2^(...(^ Xpn))...))
	
			*/
	
			case "L_ConsecutiveC":
				returnLTL = "((l1 .)& X((l2 .)(&X(l3 .))))";//(l1^X(l2^Xl3)))
				break;
			case "P_ConsecutiveC":
				returnLTL = "((p1 .)& X((p2 .)(&X(p3 .))))";//(p1^X(p2^Xp3)))
				break;
			case "Q_ConsecutiveC":
				returnLTL = "((q1 .)& X((q2 .)(&X(q3 .))))";//(q1^X(q2^Xq3)))
				break;
			case "R_ConsecutiveC":
				returnLTL = "((r1 .)& X((r2 .)(&X(r3 .))))";//(r1^X(r2^Xr3)))
				break;
	
			/*
			  Consecutive E for L, P, and Q
	
			 LTL description: (! p1 ^ ...^ ! pn) ^ ((! p1 ^ ...^ ! pn) U 
			                  (p1 ^ ! p2 ^ ...^ ! pn ^ X(p2 ^ ! p3 ^ ...^ ! pn ^ X(...^ X(pn-1 ^ ! pn ^ Xpn))...)))
	
			*/
	
			//(!l1^!l2^!l3)^((!l1^!l2^!l3)U(l1^!l2^!l3^X(l2^!l3^X(l2^!l3^Xl3))))
			case "L_ConsecutiveE":
				returnLTL = "(((!l1&!l2&!l3) .)&(((!l1&!l2&!l3) .) U (((l1&!l2&!l3) .)& X(((l2&!l3) .)& (X(l3 .))))))";
				break;
			//(!p1^!p2^!p3)^((!p1^!p2^!p3)U(p1^!p2^!p3^X(p2^!p3^X(p2^!p3^Xp3))))
			case "P_ConsecutiveE":
				returnLTL = "(((!p1&!p2&!p3) .)&(((!p1&!p2&!p3) .) U (((p1&!p2&!p3) .)& X(((p2&!p3) .)& (X(p3 .))))))";
				break;
			//(!q1^!q2^!q3)^((!q1^!q2^!q3)U(q1^!q2^!q3^X(q2^!q3^X(q2^!q3^Xq3))))
			case "Q_ConsecutiveE":
				returnLTL = "(((!q1&!q2&!q3) .)&(((!q1&!q2&!q3) .) U (((q1&!q2&!q3) .)& X(((q2&!q3) .)& (X(q3 .))))))";
				break;
	
	
			/*
			  Eventual C for L, P, Q, and R
	
			  LTL description: (p1 ^ X(! p2 U (p2 ^ X(... ^ X(!pn-1 U (pn-1 ^ X(!pn U pn))))...)))
	
			*/
	
		    case "L_EventualC":
		    	returnLTL = "((l1 .)& X((!l2 .)U ((l2 .)& X((!l3 .)U (l3 .)))))";//(l1^X(!l2 U (l2 ^ X (!l2 U (!l3 U l3)))))	
		    	break;
			case "P_EventualC":
				returnLTL = "((p1 .)& X((!p2 .)U ((p2 .)& X((!p3 .)U (p3 .)))))";//(p1^X(!p2 U (p2 ^ X (!p2 U (!p3 U p3)))))
				break;
			case "Q_EventualC":
				returnLTL = "((q1 .)& X((!q2 .)U ((q2 .)& X((!q3 .)U (q3 .)))))";//(q1^X(!q2 U (q2 ^ X (!q2 U (!q3 U q3)))))
				break;
			case "R_EventualC":
				returnLTL = "((r1 .)& X((!r2 .)U ((r2 .)& X((!r3 .)U (r3 .)))))";//(r1^X(!r2 U (r2 ^ X (!r2 U (!r3 U r3)))))	
				break;
			
			/*
			  Eventual E for L, P and Q
	
			  LTL description: (!p1...^!pn)^((!p1^...^!pn)U(p1^!p2^...^!pn^((!p2^...^!pn)U(p2^!p3^...^!pn^(...^(pn-1^!pn^(!pnUpn))...)))))
	
			*/
			
			//(!l1^!l2^!l3)^((!l1^!l2^!l3)U(l1^!l2^!l3^((!l2^!l3)U(l2^!l3^(l2^!^!l3^(!l3Ul3))))))
			case "L_EventualE":
				returnLTL = "(((!l1&!l2&!l3).)&(((!l1&!l2&!l3).) U (((l1&!l2&!l3) .)&(((!l2&!l3).) U (((l2&!l3) .)&((!l3 .) U (l3 .)))))))";
				break;
			
			//(!p1^!p2^!p3)^((!p1^!p2^!p3)U(p1^!p2^!p3^((!p2^!p3)U(p2^!p3^(p2^!^!p3^(!p3Up3))))))
			case "P_EventualE":
				returnLTL = "(((!p1&!p2&!p3).)&(((!p1&!p2&!p3).) U (((p1&!p2&!p3) .)&(((!p2&!p3).) U (((p2&!p3) .)&((!p3 .) U (p3 .)))))))";
				break;
	
			//(!q1^!q2^!q3)^((!q1^!q2^!q3)U(q1^!q2^!q3^((!q2^!q3)U(q2^!q3^(q2^!^!q3^(!q3Uq3))))))
			case "Q_EventualE":
				returnLTL = "(((!q1&!q2&!q3).)&(((!q1&!q2&!q3).) U (((q1&!q2&!q3) .)&(((!q2&!q3).) U (((q2&!q3) .)&((!q3 .) U (q3 .)))))))";
				break;
				
			default:
				returnLTL = "Requested LTL Not Found: "+requestedLTL;
		}
		return returnLTL;
	}
}
