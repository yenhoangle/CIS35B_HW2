package adapter;

public interface UpdateAuto {
    public void updateOptionSetName(String modelName, String opsetName, String newOpsetName);
    public void updateOptionPrice(String modelName, String opsetName, String opName, float newPrice);
}
