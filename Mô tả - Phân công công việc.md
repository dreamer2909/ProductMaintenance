Bài Thực hành 2 nhóm 6 - Nhóm bài tập 7

Thành viên:
- Nguyễn Xuân Đức: B15DCCN133
- Trần Thị Ngọc Anh: B19DCCN046
- Bùi Trung Hiếu: B19DCCN237

Cách làm:
- Tạo lớp thực thể Product, lớp controller ProductController, trang home.html
- Chức năng xem list product:
   + Xây dựng phương thức getProducts() (đường dẫn /display) trong lớp controller, tạo object products để truyền sang productList.html
   + Xây dựng trang view productList hiển thị dữ liệu từ products
- Chức năng update product:
   + Xây dựng method get getUpdateProduct() (đường dẫn /update) trả về object product rỗng cho trang updateProduct.html
   + Xây dựng trang updateProduct với form có các trường dữ liệu (được validate) của Product, method post và action đến đường dẫn /update
   + Xây dựng method post updateProduct() nhận đối tượng đã validate từ view, nếu product có mã code đã xuất hiện thì thực hiện việc update product,
     nếu chưa xuất hiện thì thêm vào CSDL
- Chức năng delete product:
   + Xây dựng method get getDeleteProduct() (đường dẫn /confirm) lấy dữ liệu là id từ bảng product, trả về trang deleteProduct thông tin sản phẩm cần xoá
   + Trang deleteProduct nhận về product cần xoá, khi nhấn Yes, phương thức deleteProduct() được gọi đến kèm theo id của product
   + Xây dựng method get deleteProduct() thực hiện xoá product theo id
 
 Phân công công việc:
 - Nguyễn Xuân Đức: chức năng xem sản phẩm, validate dữ liệu
 - Trần Thị Ngọc Anh: chức năng update product
 - Bùi Trung Hiếu: chức năng delete product
