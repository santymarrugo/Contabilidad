import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.time.LocalDateTime
import java.io.File
import java.lang.Integer as Int

/**
 * Fecha creacion : 12-04-2022
 * QA : Santiago Marrugo
 */
//Accesamos a la opcion Asientos
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Accesos a menu principal/Acceso a Asientos'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)

println("<------- ID 28 ------->")
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonCrearMesAsiento'))
WebUI.delay(1)
//Obtenemos la fecha actual, para extraer solo el mes y año y ese valor pasarlo como parametro al mes que vamos a crear
def String fechaCorriente = LocalDateTime.now()
println(fechaCorriente)
//2022-04-08T14:34:02.206
def String mes = fechaCorriente.substring(5, 7)
println(mes)
def String anio = fechaCorriente.substring(0, 4)
println(anio)
//Fecha que se va a pasar como parametro para crear el mes de asiento
def String fechaAsientoCrear = mes+"/"+anio
WebUI.delay(1)
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputMesAnioAsiento'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputMesAnioAsiento'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputMesAnioAsiento'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputMesAnioAsiento'), fechaAsientoCrear)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
WebUI.delay(3)
def String asientoMesNuevo = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/LabelDentrodelAsiento'))
println(asientoMesNuevo)
println(fechaAsientoCrear)
asientoMesNuevo = asientoMesNuevo.substring(9, 16)
//Comprobamos el mes de asiento correcto
assert fechaAsientoCrear == asientoMesNuevo

//Formateamos la fecha del asiento
def String fechaAsiento = fechaAsientoCrear.replace('/', '')
println(fechaAsiento)

//Fecha sin el 0 delante del mes para dejarla con el formato X/XXXX
def String fechaTituloReporte = fechaAsientoCrear.substring(1, 7)
println(fechaTituloReporte)

//Hacemos el llamado al test de crear asientos
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Carpetas/Asientos/Crear Asiento - KW'),[:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(5)

//Exportar en PDF
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonExportar'))
WebUI.delay(25)
WebUI.verifyTextPresent(fechaTituloReporte, false)
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonExportarFinal'))
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonExportarPDF'))
WebUI.delay(8)
//Esta parte se hace debido a que el archivo exportado tiene en el nombre la fecha y hora actual
println(LocalDateTime.now().plusHours(2))
//Se obtiene la fecha actual con la hora y se le suman dos hora, debido a que el reporte sale con la hora de Uruguay
def String fechaSinFormatoPDF = LocalDateTime.now().plusHours(2)
//Sacamos la fecha aparte
String fechaPDF = fechaSinFormatoPDF.substring(0, 10)
println(fechaPDF)
//Se le cambia el guion por vacio
fechaPDF = fechaPDF.replace('-', '')
println(fechaPDF)
//Sacamos la hora aparte
String horaPDF = fechaSinFormatoPDF.substring(11, 16)
println(horaPDF)
//Se le cambia el guion por vacio
horaPDF = horaPDF.replace(':', '')

//Se convierte la variable de la hora a Int para usarla mas adelante, y poder sumarle 1 minuto en caso de ser necesario
def int PDFHora = Integer.parseInt(horaPDF)
WebUI.delay(2)

//se crea un objeto de tipo File y se le pasa la ruta donde debe existir el archivo descargado
File pdfDescargado = new File("C:\\Users\\marr801550\\Downloads\\Asientos_"+ fechaAsiento + "_"+fechaPDF+'_'+PDFHora+".pdf");
WebUI.delay(2)

//Se crea una variable y se usa el metodo exist() de la clase File, para validar si encontró o no el archivo en la ruta
def verificarExistePDF = pdfDescargado.exists()
println(verificarExistePDF)

//Creamos un condicional por si al momento de descargar el archivo el nombre cambia a raiz de un cambio en la hora
//Le sumamos un minuto para que valide nuevamente el nombre del archivo
if(verificarExistePDF == false) {
	PDFHora = PDFHora + 1//sumamos un minuto
	println(PDFHora)
	pdfDescargado = new File("C:\\Users\\marr801550\\Downloads\\Asientos_"+ fechaAsiento + "_"+fechaPDF+'_'+PDFHora+".pdf");
	WebUI.delay(3)
	verificarExistePDF = pdfDescargado.exists()
	println(pdfDescargado)
	println(verificarExistePDF)
	assert verificarExistePDF == true
}else {
	WebUI.delay(1)
	//Se verifica que el archivo se haya descargado correctamente
	assert verificarExistePDF == true
	WebUI.delay(3)
}

//Exportar en EXCEL
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonExportarFinal'))
WebUI.delay(8)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonExportarExcel'))
WebUI.delay(8)
//Esta parte se hace debido a que el archivo exportado tiene en el nombre la fecha y hora actual
println(LocalDateTime.now().plusHours(2))
//Se obtiene la fecha actual con la hora y se le suman dos hora, debido a que el reporte sale con la hora de Uruguay
def String fechaSinFormatoEXCEL = LocalDateTime.now().plusHours(2)
//Sacamos la fecha aparte
String fechaEXCEL = fechaSinFormatoEXCEL.substring(0, 10)
println(fechaEXCEL)
//Se le cambia el guion por vacio
fechaEXCEL = fechaEXCEL.replace('-', '')
println(fechaEXCEL)
//Sacamos la hora aparte
String horaEXCEL = fechaSinFormatoEXCEL.substring(11, 16)
println(horaEXCEL)
//Se le cambia el guion por vacio
horaEXCEL = horaEXCEL.replace(':', '')

//Se convierte la variable de la hora a Int para usarla mas adelante, y poder sumarle 1 minuto en caso de ser necesario
def int EXCELHora = Integer.parseInt(horaEXCEL)
WebUI.delay(2)

//se crea un objeto de tipo File y se le pasa la ruta donde debe existir el archivo descargado
File EXCELDescargado = new File("C:\\Users\\marr801550\\Downloads\\Asientos_"+ fechaAsiento + "_"+fechaEXCEL+'_'+EXCELHora+".xlsx");
WebUI.delay(2)

//Se crea una variable y se usa el metodo exist() de la clase File, para validar si encontró o no el archivo en la ruta
def verificarExisteEXCEL = EXCELDescargado.exists()
println(verificarExisteEXCEL)

//Creamos un condicional por si al momento de descargar el archivo el nombre cambia a raiz de un cambio en la hora
//Le sumamos un minuto para que valide nuevamente el nombre del archivo
if(verificarExisteEXCEL == false) {
	EXCELHora = EXCELHora + 1//sumamos un minuto
	println(EXCELHora)
	EXCELDescargado = new File("C:\\Users\\marr801550\\Downloads\\Asientos_"+ fechaAsiento + "_"+fechaEXCEL+'_'+EXCELHora+".xlsx");
	WebUI.delay(3)
	verificarExisteEXCEL = EXCELDescargado.exists()
	println(EXCELDescargado)
	println(verificarExisteEXCEL)
	assert verificarExisteEXCEL == true
}
else {
	WebUI.delay(1)
	//Se verifica que el archivo se haya descargado correctamente
	assert verificarExisteEXCEL == true
	WebUI.delay(3)
}

//Exportar en WORD
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonExportarFinal'))
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonExportarWord'))
WebUI.delay(8)
//Esta parte se hace debido a que el archivo exportado tiene en el nombre la fecha y hora actual
println(LocalDateTime.now().plusHours(2))
//Se obtiene la fecha actual con la hora y se le suman dos hora, debido a que el reporte sale con la hora de Uruguay
def String fechaSinFormatoWORD = LocalDateTime.now().plusHours(2)
//Sacamos la fecha aparte
String fechaWORD = fechaSinFormatoWORD.substring(0, 10)
println(fechaWORD)
//Se le cambia el guion por vacio
fechaWORD = fechaWORD.replace('-', '')
println(fechaWORD)
//Sacamos la hora aparte
String horaWORD = fechaSinFormatoWORD.substring(11, 16)
println(horaWORD)
//Se le cambia el guion por vacio
horaWORD = horaWORD.replace(':', '')

//Se convierte la variable de la hora a Int para usarla mas adelante, y poder sumarle 1 minuto en caso de ser necesario
def int WORDHora = Integer.parseInt(horaWORD)
WebUI.delay(1)

//se crea un objeto de tipo File y se le pasa la ruta donde debe existir el archivo descargado
File WORDDescargado = new File("C:\\Users\\marr801550\\Downloads\\Asientos_"+ fechaAsiento + "_"+fechaWORD+'_'+WORDHora+".docx");
WebUI.delay(2)

//Se crea una variable y se usa el metodo exist() de la clase File, para validar si encontró o no el archivo en la ruta
def verificarExisteWORD = WORDDescargado.exists()
println(verificarExisteWORD)

//Creamos un condicional por si al momento de descargar el archivo el nombre cambia a raiz de un cambio en la hora
//Le sumamos un minuto para que valide nuevamente el nombre del archivo
if(verificarExisteWORD == false) {
	WORDHora = WORDHora + 1//sumamos un minuto
	println(WORDHora)
	WORDDescargado = new File("C:\\Users\\marr801550\\Downloads\\Asientos_"+ fechaAsiento + "_"+fechaWORD+'_'+WORDHora+".docx");
	WebUI.delay(3)
	verificarExisteWORD = WORDDescargado.exists()
	println(WORDDescargado)
	println(verificarExisteWORD)
	assert verificarExisteWORD == true
}
else {
	WebUI.delay(1)
	//Se verifica que el archivo se haya descargado correctamente
	assert verificarExisteWORD == true
	WebUI.delay(3)
}

WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonIzquierdoAsientos'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonMesCorriente'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
WebUI.delay(5)
WebUI.executeJavaScript('hot.selectCell(0,11)', null)

println("<----- ID 29 - 30 ---->")
//Ingresamos un dato invalido para verificar que se muestre el popup de los errores presentes en el asiento
WebUI.executeJavaScript('hot.setDataAtCell(0,11,"1111")', null)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(2)
WebUI.verifyTextPresent('Se ha detectado un asiento con error.', false)
WebUI.verifyTextPresent('Error: "El código de la moneda no es válido."', false)
WebUI.verifyTextPresent('¿Desea corregirlo ahora?', false)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonSIPopupErroresAsiento'))
WebUI.delay(2)
WebUI.executeJavaScript('hot.selectCell(0,11)', null)
WebUI.executeJavaScript('hot.setDataAtCell(0,11,"0")', null)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(2)
//Verificamos que nos muestre el popup para ingresar a los asientos existentes
WebUI.verifyTextPresent('Editar un mes de asientos existentes', false)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonMesCorriente'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
WebUI.delay(5)
//Seleccionamos todas las filas del mes de asiento para eliminarlas, para efectos de la regresion, ya que cada vez que se corra el mes de asiento
//sera creado.
WebUI.executeJavaScript('hot.selectRows(0,9)', null)
WebUI.delay(2)
WebUI.click(findTestObject('_Conty/Menu Principal/Carpetas/Asientos/BotonEliminarLinea'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarBorrarAsientos'))
WebUI.delay(2)
WebUI.verifyTextNotPresent('11111', false)
WebUI.delay(2)
WebUI.verifyTextNotPresent('11112', false)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonTerminar'))
WebUI.delay(2)
WebUI.verifyTextPresent('Crear un mes nuevo de asientos', false)
WebUI.delay(2)
WebUI.executeJavaScript("alert('AQUI TERMINA EL TEST')", null)
WebUI.delay(3)
WebUI.closeBrowser()
