print()
set = {
	'circlet' : {
		'CRIT_Rate' : 31.1,	# CR Circlet we already have
		#'CRIT_DMG' : 62.2,	# Hypothetical CD Circlet
		'HP' : 478,
		'HPP' : 8.2,
		'CRIT_DMG' : 27.2,	# CR Circlet we already have
		#'CRIT_Rate' : 7.4,	# Hypothetical CD Circlet
		'DEF' : 19
	},
	'goblet' : {
		'Pyro_DMG' : 46.6,
		'Energy_Recharge' : 11.0,
		'ATK' : 18,
		'CRIT_DMG' : 13.2,
		'CRIT_Rate' : 13.2
	},
	'sands' : {
		'HPP' : 46.6,
		'CRIT_DMG' : 18.7,
		'Energy_Recharge' : 6.5,
		'DEF' : 44,
		'CRIT_Rate' : 9.3
	},
	'plume' : {
		'ATK' : 311,
		'CRIT_DMG' : 7.0,
		'DEF' : 37,
		'Elemental_Mastery' : 42,
		'CRIT_Rate' : 12.1
	},
	'flower' : {
		'HP' : 4780,
		'CRIT_Rate' : 12.1,
		'Elemental_Mastery' : 42,
		'CRIT_DMG' : 12.4,
		'HPP' : 4.1
	}
}

CRIT_DMG = 88.4	# HuTao Base CRIT_DMG @Acension 6
CRIT_Rate = 5	# HuTao Base CRIT_Rate
for key in set :
	CRIT_DMG = CRIT_DMG + set[key]['CRIT_DMG']
	CRIT_Rate = CRIT_Rate + set[key]['CRIT_Rate']

print ("Base CRIT_DMG = " + str(round(CRIT_DMG, 2)))
print ("Base CRIT_Rate = " + str(round(CRIT_Rate, 2)))
print ("Base Product : " + str(round(CRIT_DMG * CRIT_Rate, 2)))
print()

DM_CRIT_Rate = 36.8	# Deathmatch CRIT_Rate @lv.90
BC_CRIT_DMG = 55.1	# Blackcliff CRIT_DMG @lv.90

print ("DM Pole CRIT_DMG = " + str(round(CRIT_DMG, 2)))
print ("DM Pole CRIT_Rate = " + str(round(CRIT_Rate + DM_CRIT_Rate, 2)))
print ("DM Pole Product : " + str(round(CRIT_DMG * ((CRIT_Rate + DM_CRIT_Rate) if (CRIT_Rate + DM_CRIT_Rate) < 100 else 100), 2))) # CRIT_Rate = 119.6 > 100
print()

print ("BC Pole CRIT_DMG = " + str(round(CRIT_DMG + BC_CRIT_DMG, 2)))
print ("BC Pole CRIT_Rate = " + str(round(CRIT_Rate, 2)))
print ("BC Pole Product : " + str(round((CRIT_DMG + BC_CRIT_DMG) * CRIT_Rate, 2)))

