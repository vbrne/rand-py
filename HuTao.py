import pickle

filename = 'HuTao_Has'

infile = open(filename, 'rb')
HuTao_Has = pickle.load(infile)
infile.close()

HuTao_Needs = {
	'Ascension_Needs' : {
	'Pyro Gem 2' : 1,
	'Pyro Gem 3' : 9,
	'Pyro Gem 4' : 9,
	'Pyro Gem 5' : 6,
	'Dino Boss Mat' : 46,
	'Silk Flower' : 168,
	'Whopper Nectar 1' : 18,
	'Shimmer Nectar 2' : 30,
	'Energy Nectar 3' : 36,
	'Mora' : 420000
	},

	'Level_Up_Needs' : {
	'Heros Wit' : 249,
	'Mora' : 975905
	},

	'Talent_Needs' : {
	'Whopper Nectar 1' : 18,
	'Shimmer Nectar 2' : 66,
	'Diligence Book 2' : 9,
	'Diligence Book 3' : 63,
	'Mora' : 112500
	}
}

HuTao_Extras = {
	'Level_Up_Extra' : {
	'Heros Wit' : 172,
	'Mora' : 684625
	},

	'Talent_Extra' : {
	'Energy Nectar 3' : 21,
	'Diligence Book 4' : 22,
	'Childe Boss Mat' : 4,
	'Mora' : 830000
	}
}

def printList(list) :
	#print ("\nAscension Materials needed for Hu Tao:")
	for key in list :
		print ("  %s : " % (key))
		for key2 in list[key] :
			print ("    %s : %s" % (key2, list[key][key2]))

def neededMora() :
	sum = 0
	for key in HuTao_Needs :
		sum = sum + HuTao_Needs[key]['Mora']
	
	print ("\nMora required for bare minimum: " + str(sum))

def printHas(has) :
	print ("\nWhat you got: ")
	for key in has :
		print ("  %s : %s" % (key, has[key]))

def update() :
	for key in HuTao_Has :
		try :
			tmp = int(input (" %s : " % key))
			HuTao_Has[key] = tmp
		except ValueError :
			print ("  Did not enter int, value unchanged.")
		print ("  -> %s : %d" % (key, HuTao_Has[key]))

	outfile = open(filename, 'wb') 
	pickle.dump(HuTao_Has, outfile)
	outfile.close()
	return
def single() :
	while True :
		k = input ("Please enter key: ")
		if k == "break" or k == "" :
			return
		try :
			HuTao_Has[k]
		except KeyError :
			print("  Invalid Key")
			continue
		break

	while True :
		try :
			tmp = int (input (" %s : " % k))
		except ValueError :
			print ("  Did not enter int..")
			continue
		break

	HuTao_Has[k] = tmp
	print ("  -> %s : %d" % (k, HuTao_Has[k]))
	
	
def infiniteLoop() :
	printHas(HuTao_Has)
	
	print ("\nOptions: update, single, break;")
	str = input()
	if str == "update" :
		print ("Update: ")
		update()
	if str == "single" :
		print ("Single: ")
		single()
	elif str == "break" or str == "":
		print ("breaking")
		return
	else :
		print ("I don't know what you said..")
	infiniteLoop()

printList(HuTao_Needs) 
#printExtras()
#neededMora()

infiniteLoop()

# Just wait for user input so program doesn't close
print()
input('Press Enter to exit...')