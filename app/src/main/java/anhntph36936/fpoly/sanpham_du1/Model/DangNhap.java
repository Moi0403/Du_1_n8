package anhntph36936.fpoly.sanpham_du1.Model;

public class DangNhap {
    private String maTT;
    private String hoten;
    private String matkhau;

    public DangNhap() {
    }

    public DangNhap(String maTT, String hoten, String matkhau) {
        this.maTT = maTT;
        this.hoten = hoten;
        this.matkhau = matkhau;
    }

    public String getMaTT() {
        return maTT;
    }

    public void setMaTT(String maTT) {
        this.maTT = maTT;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }
}
