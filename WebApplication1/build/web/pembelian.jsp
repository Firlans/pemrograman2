<%-- 
    Document   : pertemuan12
    Created on : Nov 9, 2023, 2:49:25 PM
    Author     : mr_tech
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2> Form Mamasukkan Nilai </h2>
        <form action="HitungHarga" method="post">
            <table>
                <tr>
                    <td>Nama Barang</td>
                    <td><input type="text" name="namaBarang"></td>
                </tr>
                <tr>
                    <td>Harga Satuan</td>
                    <td><input type="text" name="hargaSatuan"></td>
                </tr>
                <tr>
                    <td>Jumlah</td>
                    <td><input type="text" name="jumlah"></td>
                </tr>
                <tr>
                    <td colspan="2">Diskon diberikan sebesar 5% jika jumlah >= 100</td>
                </tr>
                <tr>
                    <td colspan="2">dan Total harga sebelum diskon >= 1000000</td>
                </tr>
                <tr>
                    <td><input type="submit" value="Hitung"</td>
                </tr>
            </table>
        </form>
    </body>
</html>
