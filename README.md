# SimpleRESTTest
2020/08/10 received Question


API分數個路徑

### 部門

# /api/department

POST為創建 參數為JSON格式

PUT為修改 參數為JSON格式

# /api/department/{id}

DELETE為刪除 

### 人員

# /api/employee

GET為查詢，參數由QueryString給出 

page(分頁)

age(年齡)

departmentName(部門名稱)

id(員工編號)

name(姓名)

POST為創建 參數為JSON格式

PUT為修改 參數為JSON格式

# /api/employee/{id}

DELETE為刪除 

### 單元測試部分

因此專案人員查詢幾乎直接使用JPA而未做其他處理，因此判斷在此使用Mockito測試意義可能不大，故未做測試。
其他方法皆有測試

