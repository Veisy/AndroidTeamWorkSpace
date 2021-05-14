package HW4;

public class QuickSorter extends Sorter{

    public QuickSorter(double[] list) {
        super(list);
    }

    @Override
    public void sort() {
        double[] list = super.list;

        int startingLow = 0;
        int startingHigh = list.length - 1;
        quickSort(list,startingLow,startingHigh);
    }

    @Override
    public String getAlgorithmName() {
        return "Quick";
    }

    public void quickSort(double[] list,int low,int high){

       if(list.length !=1 && high>low){
            int pi = partition(list,low,high);

            quickSort(list,low,pi-1);
            quickSort(list,pi+1,high);
        }
    }
    public int partition(double[] list,int low,int high){

        double pivot=list[high];
        int i=low-1;
        double value;
        for(int j=low;j<high;j++){
            if(list[j]<=pivot){
                i+=1;
                value=list[i];
                list[i]=list[j];
                list[j]=value;
            }
        }
        value=list[i+1];
        list[i+1]=list[high];
        list[high]=value;

        return i+1;
    }
}
