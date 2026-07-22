import java.util.*;

class countInversion{

	public int cntInversion(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
		return mergeSort(nums, 0, nums.length - 1);
	}

	public void merge(int[] nums, int left, int mid, int right){
		int[] temp = new int[right - left + 1];

		int i = left;
		int j = mid + 1;
		int k = 0;

		while(i <= mid && j <= right){
			if(nums[i] <= nums[j]){
				temp[k++] = nums[i++];
			}else{
				temp[k++] = nums[j++];
			}
		}

		while(i <= mid) temp[k++] = nums[i++];
		while(j <= right) temp[k++] = nums[j++];
		for(int p = 0; p < temp.length; p++){
			nums[left + p] = temp[p];
		}
	}


	public int countPairs(int[] nums, int low, int mid, int high){
		int right = mid + 1;

		int cnt = 0;

		for(int i = low; i <= mid; i++){
			while(right <= high && nums[i] > nums[right]){
				right++;
			}
			cnt += right - (mid + 1);
		}
		return cnt;
	}


	public int mergeSort(int[] nums, int low, int high){
		if(low >= high) return 0;

		int mid = low + (high - low) / 2;
		int count = 0;
		count += mergeSort(nums,low,mid);
		count += mergeSort(nums,mid+1, high);
		count += countPairs(nums,low,mid,high);
		merge(nums,low,mid,high);
		return count;
	}
}




	
class Main{

	public static void main(String[] args){
		countInversion cntI = new countInversion();	
		int[] test1 = {1,2,4,1,3,5};
		int[] test2 = {2,3,4,5,6};
		System.out.println(cntI.cntInversion(test1));
		System.out.println(cntI.cntInversion(test2));

		return ;
	}
}

