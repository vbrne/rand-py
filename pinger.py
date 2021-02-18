import time
from pythonping import ping

counter = 0
gucciSleep = False
while (True) :
	timee = time.strftime("%H:%M:%S", time.localtime())
	pingg = ping('8.8.8.8', count=1, timeout=1).rtt_min_ms
	if pingg >= 100 :
		gucciSleep = False
		counter = 0
		print (timee, "Timeout ;-;", pingg)
		f = open ("gucciTimes.txt", "a")
		f.write(timee + "Timout! " + str(pingg) + "\n")
		f.close()

	elif counter < 5 :
		counter = counter + 1
		print (timee, "Gucci")
	elif not gucciSleep :
		gucciSleep = True
		print ("-------------- Gucci Sleep")
		f = open ("gucciTimes.txt", "a")
		f.write("\n")
		f.close()
	
	time.sleep(0.5)
