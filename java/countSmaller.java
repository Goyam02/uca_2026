import java.util.*;


class CountSmaller{

	class Pair{
		int val;
		int idx;

		Pair(int val, int idx){
			this.val = val;
			this.idx = idx;
		}
	}

	public int[] countSmaller(int[] nums){
		if(nums == null || nums.length == 0) return new int[0];

		int n = nums.length;
		int[] ans = new int[n];
		Pair[] arr = new Pair[n];

		for(int i = 0; i < n; i++){
			arr[i] = new Pair(nums[i], i);
		}

		mergeSort(arr,0,n-1,ans);

		return ans;
	}


	public void merge(Pair[] arr, int left, int mid, int right, int[] ans){
		Pair[] temp = new Pair[right - left + 1];

		int i = left;
		int j = mid + 1;
		int k = 0;

		int smaller = 0;

		while(i <= mid && j <= right){
			if(arr[i].val <= arr[j].val){
				ans[arr[i].idx] += smaller;
				temp[k++] = arr[i++];
			}else{
				smaller++;
				temp[k++] = arr[j++];
			}
		}

		while(i <= mid){
			ans[arr[i].idx] += smaller;
			temp[k++] = arr[i++];
		}

		while(j <= right) temp[k++] = arr[j++];

		for(int p = 0; p < temp.length; p++){
			arr[left + p] = temp[p];
		}
	}


	public void mergeSort(Pair[] arr, int low, int high, int[] ans){
		if(low >= high) return;

		int mid = low + (high - low) / 2;

		mergeSort(arr,low,mid,ans);
		mergeSort(arr,mid+1,high,ans);

		merge(arr,low,mid,high,ans);
	}
}




class Main{

	public static void main(String[] args){
		CountSmaller cs = new CountSmaller();

		int[] test1 = {5,2,6,1};
		int[] test2 = {-1};
		int[] test3 = {-1,-1};

		System.out.println(Arrays.toString(cs.countSmaller(test1)));
		System.out.println(Arrays.toString(cs.countSmaller(test2)));
		System.out.println(Arrays.toString(cs.countSmaller(test3)));

		return ;
	}
}
