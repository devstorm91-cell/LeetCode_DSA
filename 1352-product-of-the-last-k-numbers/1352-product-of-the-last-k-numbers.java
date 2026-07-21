class ProductOfNumbers {
    private List<Integer> prefixproducts;

    public ProductOfNumbers() {
        prefixproducts=new ArrayList<>();
        prefixproducts.add(1);    
    }
    
    public void add(int num) {
        if(num==0){
            prefixproducts=new ArrayList<>();
            prefixproducts.add(1);
        }else{
            int lastproduct=prefixproducts.get(prefixproducts.size()-1);
            prefixproducts.add(lastproduct*num);
        }
    }
    
    public int getProduct(int k) {
        int size=prefixproducts.size();
        if (k>=size){
            return 0;
        }
        return prefixproducts.get(size-1)/prefixproducts.get(size-1-k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */