Class.forName("com.mysql.cj.jdbc.Driver");
Connection conn = DriverManager.getConnection(
  "jdbc:mysql://us-east.connect.psdb.cloud/mmdb?sslMode=VERIFY_IDENTITY",
  "jgttt2vuns7f41289x1f",
  "pscale_pw_PdWosiKu9JOhr2mbsGZ9FgBETKUkWSbmGfuQF93sW7R");