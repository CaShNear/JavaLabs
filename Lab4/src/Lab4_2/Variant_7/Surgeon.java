package Lab4_2.Variant_7;

public class Surgeon implements Doctor{

    protected String DoctorType = "Surgeon";
    @Override
    public void treatPatient() {
        System.out.println(DoctorType);
    }

}
