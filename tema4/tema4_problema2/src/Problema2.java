import acm.program.CommandLineProgram;

public class Problema2 extends CommandLineProgram {
    public void run() {
        int[] mcd = {412, 184} ;
        mcd = euclides(mcd);
        println(mcd[0] + ", " + mcd[1]);

    }

    public int[] euclides (int[] nums) {
        if (nums[0] == nums[1]) {
            return nums;
        } else {
            if (nums[0] > nums[1]) {
                nums[0] = -nums[1];
            } else {
                nums[1] =- nums[0];
            }
            return euclides(nums);
        }
    }
}
