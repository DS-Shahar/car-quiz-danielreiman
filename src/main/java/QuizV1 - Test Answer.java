public class CarInfo {
	public boolean illegal(int maxSpeed) {
		if (this.privateCar || this.speed > maxSpeed) {
			return true;
		}
		
		return false;
	}
}

public class CameraInfo {
	public boolean allGood() {
		for (int carIndex=0; carIndex < this.cars.length; carIndex++) {
			if (cars[carIndex].illegal()) {
				return false;
			}
		}
		
		return true;
	}
}

public class Main {
	public static int legalCities(CameraInfo[] cameras) {
		int result = 0;
		int[] scannedCities = new int[100];
		
		for (int cIndex=0; cIndex<cameras.length;cIndex++) {
			if (cameras[cIndex].allGood()) {
				boolean isFound = false;
				for (int code=0;code<scannedCities.length;code++) {
					if (cameras[cIndex].city==scannedCities[code]) {
						isFound = true;
					} else {
						scannedCities[result] = cameras[cIndex].city;
						result++;
					}
				}
			}
		}
	}
}
