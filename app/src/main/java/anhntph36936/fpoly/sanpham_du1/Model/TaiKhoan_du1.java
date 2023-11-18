package anhntph36936.fpoly.sanpham_du1.Model;

public class TaiKhoan_du1 {
    private int maTK;
    private String emailTK;
    private String userTK;
    private String matKhau;
    private String laiMatKhau;



    public TaiKhoan_du1(int maTK, String emailTK, String userTK, String matKhau, String laiMatKhau) {
        this.maTK = this.maTK;
        this.emailTK = this.emailTK;
        this.userTK = this.userTK;
        this.matKhau = this.matKhau;
        this.laiMatKhau = this.laiMatKhau;
    }

    public TaiKhoan_du1() {

    }

    public int getMaTK() {
        return maTK;
    }

    public void setMaTK(int maTK) {
        this.maTK = maTK;
    }

    public String getEmailTK() {
        return emailTK;
    }

    public void setEmailTK(String emailTK) {
        this.emailTK = emailTK;
    }

    public String getUserTK() {
        return userTK;
    }

    public void setUserTK(String userTK) {
        this.userTK = userTK;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getLaiMatKhau() {
        return laiMatKhau;
    }

    public void setLaiMatKhau(String laiMatKhau) {
        this.laiMatKhau = laiMatKhau;
    }

}
