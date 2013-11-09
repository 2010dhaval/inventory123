<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">  
    <html>  
        <head>
        #wrapper {
    width: 500px;
    border: 1px solid black;
    overflow: auto;
}
#first {
    float: left;
    width: 300px;
    border: 1px solid red;
}
#second {
    border: 1px solid green;
    margin: 0 0 0 302px;
}

          
            <title>Navigation Effect Using jQuery</title>  
            <link rel="stylesheet" type="text/css" href="styles.css" />  
            <script type="text/javascript" src="jquery.js"></script>  
            <script type="text/javascript" src="sliding_effect.js"></script>  
        </head>  
        <body>  
      
            <div id="first">  
                <ul id="sliding-navigation">  
                    <li class="sliding-element"><h3>Navigation Title</h3></li>  
                    <li class="sliding-element"><a href="#">Link 1</a></li>  
                    <li class="sliding-element"><a href="#">Link 2</a></li>  
                    <li class="sliding-element"><a href="#">Link 3</a></li>  
                    <li class="sliding-element"><a href="#">Link 4</a></li>  
                    <li class="sliding-element"><a href="#">Link 5</a></li>  
                </ul>  
            </div>
    <div id="second">
            ASDFGHJK
            </div>  
        </body>  
    </html>  