public class CanPlaceFlower {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if(n == 0) return true;

        if(flowerbed.length == 1) {
            return flowerbed[0] == 0 ? true : false;
        }else if (flowerbed.length == 2) {
            return flowerbed[0] == 0 && flowerbed[1] == 0 && n <= 1 ? true : false;
        }

        if(flowerbed[0] == 0 && flowerbed[1] == 0){
            flowerbed[0] = 1;
            n--;
        }

        if(flowerbed[flowerbed.length-1] == 0 && flowerbed[flowerbed.length -2] == 0){
            flowerbed[flowerbed.length-1] = 1;
            n--;

        }

        for(int i = 1; i < flowerbed.length -1; i++) {
            int left = flowerbed[i - 1];
            int right = flowerbed[i + 1];
            if(left == 0 &&  flowerbed[i] == 0 && right == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }

    public static void main(String[] args) {
        System.out.println(new CanPlaceFlower().canPlaceFlowers(new int []{0,0,0,0},3));
    }
}
