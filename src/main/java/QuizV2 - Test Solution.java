
public class CarInfo {
	public boolean illegal(int maxSpeed) {
		return (this.privateCar || this.speed > maxSpeed);
	}
}

public class CameraInfo {
	public boolean allGood() {
		for (int carIndex=0; carIndex < this.cars.length; carIndex++) {
			if (cars[carIndex].illegal(this.maxSpeed)) {
				return false;
			}
		}
		
		return true;
	}
}

public class Main {
	public static int legalCities(CameraInfo[] cameras) {
		int result = 0;
		int[] citiesTotal = new int[100];
		
		for (int cIndex=0; cIndex<cameras.length;cIndex++) {
			if (cameras[cIndex].allGood()) {
				citiesTotal[cameras[cIndex].getCity()]++;
			}
		}
		
		for (int cIndex=0; cIndex<cameras.length;cIndex++) {
			for (int ctIndex=0; ctIndex<citiesTotal.length; ctIndex++) {
				if (cameras[cIndex].getCars().length == citiesTotal[cameras[cIndex].getCity()]) {
					result++;
				}
			}
		}
		
		return result;
	}
}
