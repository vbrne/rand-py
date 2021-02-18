import pickle
filename = 'HuTao_Has'
outfile = open(filename, 'wb') 
HuTao_Has = {
	'Pyro Gem 2' : 1,
	'Pyro Gem 3' : 9,
	'Pyro Gem 4' : 9,
	'Pyro Gem 5' : 6,
	'Dino Boss Mat' : 46,
	'Silk Flower' : 168,
	'Whopper Nectar 1' : 18,
	'Shimmer Nectar 2' : 30,
	'Energy Nectar 3' : 36,
	'Heros Wit' : 249,
	'Diligence Book 2' : 9,
	'Diligence Book 3' : 0,
	'Diligence Book 4' : 0,
	'Childe Boss Mat' : 0,
	'Mora' : 0
}
pickle.dump(HuTao_Has, outfile)
outfile.close()