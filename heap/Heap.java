
public class Heap<T> {

	// create variables sort the heap
	private int[] originArr;
	public int[] heapArr;
	private int maxSize;
	public int currentSize;

	// initialize a heap with array keys of n elements
	public void heap(int[] keys, int n) {

		// add the value from input keys in originArr
		this.originArr = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			this.originArr[i] = keys[i];
		}
		// initialize the heapArr
		this.heapArr = new int[(2 * n)];
		this.maxSize = n;
		this.currentSize = n;

		// using heap sort, sort the value in originArr then put in heapArr
		for (int i = n; i <= (2 * n) - 1; i++) {
			this.heapArr[i] = i - n + 1;
		}
		for (int i = n - 1; i >= 1; i--) {
			if (this.originArr[this.heapArr[2 * i]] < this.originArr[this.heapArr[(2 * i) + 1]]) {
				this.heapArr[i] = this.heapArr[2 * i];
			} else {
				this.heapArr[i] = this.heapArr[(2 * i) + 1];
			}
		}
	}

	// returns true if the element whose id in the heap
	public boolean in_heap(int id) {
		int elementKey = this.key(id);
		// check in originArr
		for (int i = 1; i < originArr.length; i++) {
			if (originArr[i] == elementKey) {
				return true;
			}
		}
		return false;
	}

	// returns the minimum key of heap
	public int min_key() {
		return this.originArr[this.heapArr[1]];
	}

	// return the id of the element with minimum key
	public int min_id() {
		return this.heapArr[1];
	}

	// return the key for the given id
	public int key(int id) {
		return this.originArr[id];
	}

	// delete the element with minimum key from heap
	public void delete_min() {
		this.currentSize--;
		this.originArr[0] = Integer.MAX_VALUE;
		int newValue = this.heapArr[1] + this.maxSize - 1;
		this.heapArr[newValue] = 0;
		int index = newValue / 2;

		while (index >= 1) {
			if (this.originArr[this.heapArr[2 * index]] < this.originArr[this.heapArr[(2 * index) + 1]]) {
				this.heapArr[index] = this.heapArr[2 * index];
			} else {
				this.heapArr[index] = this.heapArr[(2 * index) + 1];
			}
			index = index / 2;
		}
	}

	// sets the key of the element id with the new key which is new_key
	public void decrease_key(int id, int new_key) {
		if (this.key(id) > new_key) {
			this.originArr[id] = new_key;
			int i = (id + maxSize - 1) / 2;
			while (i >= 1) {
				if (this.originArr[this.heapArr[2 * i]] < this.originArr[this.heapArr[(2 * i) + 1]]) {
					this.heapArr[i] = this.heapArr[2 * i];
				} else {
					this.heapArr[i] = this.heapArr[(2 * i) + 1];
				}
				i = i / 2;
			}
		}
	}
}
