public class ArrayList implements List {
    
    private Object[] newList;
    private int length;
    private int nextFree;
    
    public void ArrayList(int size){
        newList = new Object[size];
        length = size;
        nextFree = 0;
    }
    
    public boolean isEmpty(){
        if (nextFree == 0){
            return true;
        } else {
            return false;
        }
    }
    
    public int size(){
        if(isEmpty()){
            return 0;
        } else {
            return nextFree - 1;
        }
    }
    
    public ReturnObject get(int index){
        if(index < 0 || index >= nextFree){
            ReturnObjectImpl error;
            if(nextFree == 0){
                error = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
            } else {
                error = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
            }
            return error;
        } else {
            ReturnObjectImpl returnItem = new ReturnObjectImpl(newList[index]);
            return returnItem;
        }
    }
    
    public ReturnObject remove(int index){
        if(index < 0 || index >= nextFree){
            ReturnObjectImpl error;
            if(nextFree == 0){
                error = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
            } else {
                error = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
            }
            return error;
        } else {
            ReturnObjectImpl returnItem = new ReturnObjectImpl(newList[index]);
            for(int i = index; i < nextFree-1; i++){
                newList[i] = newList[i+1];
            }
            newList[nextFree-1] = null;
            return returnItem;
        }
    }
    
    public ReturnObject add(int index, Object item){
        if(index < 0 || index >= nextFree){
            ReturnObjectImpl error;
            if(nextFree == 0){
                error = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
            } else {
                error = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
            }
            return error;
        } else {
            for(int i = nextFree; i > index; i--){
                newList[i] = newList[i-1];
            }
            ReturnObjectImpl returnItem = new ReturnObjectImpl(newList[index]);
            newList[index] = item;
            return returnItem;
        }
    }
    
    public ReturnObject add(Object item){
        if(item == null){
            ReturnObjectImpl error = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
            return error;
        } else {
            newList[nextFree] = item;
            nextFree =+ 1;
            ReturnObjectImpl empty = new ReturnObjectImpl();
            return empty;
        }
    }
}