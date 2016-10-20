
TYPES{
	*initClass{
		(
			Event.addEventType(\appo,{ arg self;
				var dur, mtranspose;
				~degree=(~degree+~mtranspose).degreeToKey(~scale?[0,2,4],7);
				~scale=~mode ? #[0,2,4,5,7,9,11];
				~appo !? {
					if(~appo==0){dur=0}
					{
						mtranspose=Pseq(({[-1,1].choose}!~appo?1));
						dur=(~dur!(~appo)).normalizeSum * ~dur;
					}
				} ??
				{	dur=~dur.value			};
				~type=\note;
				Pbind(\dur, dur.pseq, \mtranspose, mtranspose?0)
				.play(protoEvent:currentEnvironment);
				//	~type=\note; currentEnvironment.play
			});
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
