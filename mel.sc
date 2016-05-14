
Mel{
	*initClass{
		(
			Event.addEventType(\mel, {
				~degree.postln;
				if(~degree.isArray){
					~lag=(0, ~dur/~degree.size .. ~dur).drop(-1);
					~legato= ~lag.differentiate.drop(1)++(~dur - ~lag.last)
				};
				~type=\note;
				currentEnvironment.play
			})
		)
	}
}

// (
// Pbind(
// 	\type, \mel,
// 	\degree, Pseq([0, [0,1,2,3], 5]),
// 	// \lag, a=[0, 0.3, 0.5,0.2].sort,
// 	// \legato, a.differentiate.drop(1)++(1-a.last)
// ).trace.play
// )
