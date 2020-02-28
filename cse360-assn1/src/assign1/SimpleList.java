//Name: Christopher Swanson
//ID: 1212763901
//Assignment 1
//This file is a simple list structure with simple functions to add, remove, and search in the list.

package assign1;

public class SimpleList {

	protected int[] list;
	protected int count;
	protected int listSize;

	public SimpleList() {
		listSize = 10;
		list = new int[listSize];
		count = 0;
	}

	/**
	 * This method adds a specified number to the front of the list.
	 * 
	 * @param addDigit the number to be added to the list
	 */
	
	public void add(int addDigit) {
		//if there are less than ten numbers in the list, the count should increase
		if (count < listSize) {
			//this for loop shifts all digits one position to the right
			for (int loopPos = count; loopPos > 0; loopPos--) {
				list[loopPos] = list[loopPos-1];
			}
			list[0] = addDigit;
			count++;
		}
		
		//if not, the count should remain at 10.
		else {
			listSize = (int) Math.floor(listSize*1.5);
			list = copyList(list);
			add(addDigit);
			count++;
		}
	}
	
	/**
	 * This method copies a list to expand its size.
	 * 
	 * @param listToCopy 
	 * @return returns a copied list.
	 */
	public int[] copyList(int[] listToCopy) {
		int[] newList = new int[listSize];
		for (int loopPos = 0; loopPos < count; loopPos++) {
			newList[loopPos] = list[loopPos];
		}
		
		return newList;
	}
	
	/**
	 * This method removes a number, if it is contained within the list.
	 * Other numbers will shift to the left to fill the removed number's place.
	 * 
	 * @param removeDigit number to be removed
	 */
	public void remove(int removeDigit) {
		int position = search(removeDigit);
		if (position != -1) {
			//this for loop shifts all numbers after the removed digit's position to the left
			for (int loopPos = position; loopPos < count-1; loopPos++) {
				list[loopPos] = list[loopPos+1];
			}
			list[count-1] = 0;
			count--;
		}
		
		if (count < ((int) .75*listSize)) {
			listSize = (int) .75*listSize;
			copyList(list);
			count--;
		}
	}
	
	/**
	 * Returns the current carrying capacity of the list
	 * @return listSize
	 */
	public int size() {
		return listSize;
	}
	
	/**
	 * Returns the first element of the list
	 * 
	 * @return list[0]
	 */
	public int first() {
		return list[0];
	}
	
	/**
	 * Similar to add, except the digit is added to the end of the list rather than the beginning.
	 * @param appendDigit the number to add to the list. 
	 */
	
	public void append(int appendDigit) {
		//if there are less than ten numbers in the list, the count should increase
				if (count < listSize) {
					//this for loop shifts all digits one position to the right
					list[count] = appendDigit;
					count++;
				}
				
				//if not, the count should remain at 10.
				else {
					listSize = (int) Math.floor(listSize*1.5);
					list = copyList(list);
					append(appendDigit);
				}
	}
	
	/**
	 * This method returns the current number of elements in the list.
	 * @return number of elements in the list
	 */
	public int count() {
		return count;
	}
	
	/**
	 * This method returns the elements in the list, in order, separated by a space.
	 * The last element is not followed by a space.
	 */
	public String toString() {
		String str = "";
		for (int loopPos = 0; loopPos < count-1; loopPos++) {
			str = str + list[loopPos] + " ";
		}
		
		str = str+ list[count-1];
		
		return str;
	}
	
	/**
	 * This method returns the index of a specified number.
	 * If the number is not in the list, it returns -1.
	 * @param searchDigit the number to be searched for.
	 * @return			  the index of the found number.
	 */
	public int search(int searchDigit) {
		int location = -1;
		for (int loopPos = 0; loopPos < count; loopPos++) {
			if (list[loopPos] == searchDigit) {
				location = loopPos;
			}
		}
		return location;
	}
}