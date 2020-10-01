public class main
{
    public static void main(String args[ ])
    {
        //task_1 task1 = new task_1();
        //SortingStudentsByGPA task2 = new SortingStudentsByGPA();
        task_3 task3 = new task_3();
    }
}

class Student{
    private int iDNumber;
    private int mark;
    Student(int id){this.iDNumber = id;}
    Student(int id,int mark){this.iDNumber = id; this.mark = mark;}
    public int getMark(){return mark;};
    public int getId(){return iDNumber;}
}
class task_1{
    //сортировка вставками
    Student[] arr = new Student[10];
    void printArr()
    {
        for(Student i : arr)
        {
            System.out.print(i.getId() + " ");
        }
        System.out.println();
    }

    task_1(){
        for(int i =0;i<10;i++)
        {
            arr[i] = new Student((int) (Math.random() * 999));
        }
        printArr();

        for(int i = 1;i<10;i++)
        {
            for(int j = i;j>0;j--)
            {
                if(arr[j].getId()<arr[j-1].getId()) {
                    Student tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        printArr();
    }
}

interface Comparator{
     static void quickSort(Student[] array, int low, int high) {
        if (array.length == 0)
            return;//завершить выполнение если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle].getMark();

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i].getMark() < opora) {
                i++;
            }

            while (array[j].getMark() > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                Student temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }
}
class SortingStudentsByGPA implements Comparator{
    Student arr[] = new Student[10];
    void printArr()
    {
        for(Student i : arr)
        {
            System.out.print(i.getMark() + " ");
        }
        System.out.println();
    }
    SortingStudentsByGPA(){
        for(int i =0;i<10;i++)
        {
            arr[i] = new Student(i,(int)(Math.random()*10));
        }
        printArr();
        Comparator.quickSort(arr,0,9);
        printArr();
    }
}

class task_3{
    void printArr(Student[] arr){
        for(Student i : arr)
        {
            System.out.print(i.getId() + " ");
        }
        System.out.println();
    }
    task_3()
    {
        Student[] arr1 = new Student[10];
        Student[] arr2 = new Student[10];
        Student[] res = new Student[20];
        for(int i =0;i<10;i++)
        {
            arr1[i] = new Student((int) (Math.random() * 999));
            arr2[i] = new Student((int) (Math.random() * 999));
        }
        printArr(arr1);
        printArr(arr2);
        merge(res,arr1,arr2,10,10);
        mergeSort(res,20);
        printArr(res);
    }
    public static void mergeSort(Student[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        Student[] l = new Student[mid];
        Student[] r = new Student[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }
    public static void merge(
            Student[] a, Student[] l, Student[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i].getId() <= r[j].getId()) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}
