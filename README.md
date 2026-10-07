# Bài tập OOP Java

Ba bài tập cơ bản về lập trình hướng đối tượng trong Java: Encapsulation, Inheritance + Polymorphism, Abstraction + Interface.

## Cấu trúc

| File | Nội dung | Khái niệm |
|---|---|---|
| `Bai1_Encapsulation.java` | Quản lý tài khoản ngân hàng | `private`, constructor, getter/setter có kiểm tra |
| `Bai2_Inheritance.java` | Hệ thống tính lương nhân sự | `extends`, `super`, `protected`, `@Override`, Dynamic Method Dispatch |
| `Bai3_Interface.java` | Cổng thanh toán đơn hàng | `interface`, `implements`, lập trình theo interface |
| `notes/` | Ảnh ghi chép tay trong quá trình học | |

## Cách chạy

```bash
javac Bai1_Encapsulation.java
java Bai1_Encapsulation
```

Tương tự cho `Bai2_Inheritance` và `Bai3_Interface`.

Nếu dùng JDK 11 trở lên, có thể chạy trực tiếp không cần biên dịch:

```bash
java Bai1_Encapsulation.java
```

## Tóm tắt kiến thức

### Bài 1 — Encapsulation

Dữ liệu để `private` nên bên ngoài không sửa trực tiếp được. Muốn thay đổi số dư phải đi qua `deposit()` / `withdraw()` — hai method `public` có kiểm tra điều kiện bên trong. Constructor đóng vai trò trạm gác đầu tiên, chặn số dư âm ngay lúc object được tạo.

Kết quả: gọi `deposit(-500)` và `withdraw(3000)` khi số dư không đủ, số dư vẫn giữ nguyên.

### Bài 2 — Inheritance + Polymorphism

`Employee` giữ phần chung (`id`, `name`, `baseSalary`, `displayInfo()`). Hai class con `extends` nó và chỉ khai báo thêm field riêng, rồi `@Override` lại `calculateSalary()` theo công thức của mình.

Trong `main`, cả ba object nằm chung `List<Employee>` và được duyệt bằng **một** vòng `for-each`. Java chọn `calculateSalary()` theo object thật chứ không theo kiểu của biến — đó là Dynamic Method Dispatch.

### Bài 3 — Abstraction + Interface

`PaymentMethod` là bản hợp đồng, chỉ nêu hai việc phải làm được: `pay()` và `getPaymentDetails()`. Hai class `implements` nó và tự quyết định cách thực hiện.

`Order` khai báo field kiểu `PaymentMethod` nên không hề biết bên trong là thẻ tín dụng hay ví điện tử. Đổi phương thức thanh toán mà không sửa một dòng nào trong `Order`.

## Bản đồ khái niệm

```
Class (bản thiết kế)
   ↓  new
Object (vật thật)
   ↓
Encapsulation   — private + public method có kiểm tra
   ↓
Inheritance     — extends, super, protected
   ↓
Polymorphism    — @Override, biến kiểu cha
   ↓
Abstraction
   ↓
Interface       — implements
```
