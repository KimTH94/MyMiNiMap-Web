<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="css/bootstrap-FileUpload.css" rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
<script src="https://netdna.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="css/bootstrap-FileUpload.js"></script>
<body>
<div class="fileupload-wrapper">
  <div id="myUpload"></div>
</div>
<script type="text/javascript">
$("#myUpload").bootstrapFileUpload({
	  url: 'saveProfilePhoto.jsp',
	  fileTypes: {
	    images: ["bmp", "tif", "tiff", "gif", "jpeg", "jpg", "png", "svg", "ico", "raw"]
	  },
	fallbackUrl: null,
	formMethod: 'post',
	multiFile: true,
	multiUpload: false,
	inputName: 'files',
	hiddenInput: null,
	forceFallback: false,
	maxSize: 5,
	maxFiles: null,
	showThumb: true,
	thumbWidth: 80,
	thumbHeight: 80,debug: true,
	
	onInit: function () {},
	  onFileAdded: function () {},
	  onFileRemoved: function () {},
	  onFileCancel: function () {},
	  onFileProcessing: function () {},
	  onUploadProgress: function () {},
	  onUploadError: function () {},
	  onUploadSuccess: function () {},
	  onUploadComplete: function () {},
	  onUploadReset: function () {}
	});
</script>
</body>
</html>