
public class MergeSortAlgo {
	
	private void merge(int data[], int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		var left = new int[n1];
		var right = new int[n2];
		for(int i = 0; i < n1 ; i++ ) left[i] = data[l+i];
		for(int i = 0; i < n2 ; i++ ) right[i] = data[m+1+i];
		
		int i=0, j=0, k=l;
		while( i < n1 && j < n2 ) {
			if(left[i] < right[j]) {
				data[k++] = left[i++];
			} else {
				data[k++] = right[j++];
			}
		}
		while(i < n1) {
			data[k++] = left[i++];
		}
		while(j < n2) {
			data[k++] = right[j++];
		}
	}
	
	public void mergeSort(int[] data, int l, int r) {
		if(l < r) {
			int mid = (l+r)/2;
			mergeSort(data, l , mid);
			mergeSort(data, mid+1, r);
			merge(data, l, mid, r);
		}
	}
	
	public static void main(String args[]) {
		MergeSortAlgo mergeSortAlgo = new MergeSortAlgo();
		int data[] = {9,5,7,3,8,4,6,2};
		for(int x:data) System.out.println(x);
		
		mergeSortAlgo.mergeSort(data, 0, data.length-1);
		System.out.println("-------------------------------------------------------------------");
		for(int x:data) System.out.println(x);
	}
}