<%@page pageEncoding="UTF-8" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/home">SHOPCHIEN</a>
        <button
                class="navbar-toggler"
                type="button"
                data-mdb-toggle="collapse"
                data-mdb-target="#navbarNav"
                aria-controls="navbarNav"
                aria-expanded="false"
                aria-label="Toggle navigation"
        >
            <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdown07XL" data-bs-toggle="dropdown"
                       aria-expanded="false">Tài khoản</a>
                    <ul class="dropdown-menu" aria-labelledby="dropdown07XL">
                        <li><a class="dropdown-item" href="/backend/user/list">Danh sách</a></li>
                        <li><a class="dropdown-item" href="/backend/user/create">Tạo mới</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdown07XL" data-bs-toggle="dropdown"
                       aria-expanded="false">Sản phẩm</a>
                    <ul class="dropdown-menu" aria-labelledby="dropdown07XL">
                        <li><a class="dropdown-item" href="/backend/product/list">Danh sách</a></li>
                        <li><a class="dropdown-item" href="/backend/product/create">Tạo mới</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>




