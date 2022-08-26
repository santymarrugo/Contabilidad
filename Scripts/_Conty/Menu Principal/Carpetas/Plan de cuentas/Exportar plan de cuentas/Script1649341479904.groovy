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
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys
import java.io.File
import java.util.Date
import java.time.LocalDateTime
import java.util.Calendar
import java.lang.Float as Float
import java.lang.Integer as Int
import java.text.SimpleDateFormat


/**
 * Fecha : 07-04-2022
 * QA :  Santiago Marrugo
 *
 */

//Iniciamos sesion en la plataforma Conty
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Accesos a menu principal/Acceso a Plan de Cuentas'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(2)

/**
 * Exportar en PDF
 */
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonExportar'))
WebUI.delay(20)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonExportarFinal'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonExportarPDF'))
WebUI.delay(8)

//Esta parte se hace debido a que el archivo exportado tiene en el nombre la fecha y hora actual
println(LocalDateTime.now().plusHours(2))
//Se obtiene la fecha actual con la hora y se le suman dos hora, debido a que el reporte sale con la hora de Uruguay
def String fechaSinFormatoPDF = LocalDateTime.now().plusHours(2)

//Sacamos la fecha aparte
String fechaPDF = fechaSinFormatoPDF.substring(0, 10)
//Se le cambia el guion por vacio
fechaPDF = fechaPDF.replace('-', '')

//Sacamos la hora aparte
String horaPDF = fechaSinFormatoPDF.substring(11, 16)
//Se le cambia el guion por vacio
horaPDF = horaPDF.replace(':', '')

//Se convierte la variable de la hora a Int para usarla mas adelante, y poder sumarle 1 minuto en caso de ser necesario
def int PDFHora = Integer.parseInt(horaPDF)
WebUI.delay(1)

//Se crea un objeto de tipo File y se le pasa la ruta donde debe existir el archivo descargado
File pdfDescargado = new File("C:\\Users\\marr801550\\Downloads\\PlanDeCuentas_"+fechaPDF+'_'+PDFHora+".pdf");
WebUI.delay(2)

//Se crea una variable y se usa el metodo exists() de la clase File, para validar si encontró o no el archivo en la ruta
def verificarExistePDF = pdfDescargado.exists()
println(verificarExistePDF)

//Creamos un condicional por si al momento de descargar el archivo el nombre cambia a raiz de un cambio en la hora
//Le sumamos un minuto para que valide nuevamente el nombre del archivo
if(verificarExistePDF == false) {
	PDFHora = PDFHora + 1//sumamos un minuto
	println(PDFHora)
	pdfDescargado = new File("C:\\Users\\marr801550\\Downloads\\PlanDeCuentas_"+fechaPDF+'_'+PDFHora+".pdf");
	verificarExistePDF = pdfDescargado.exists()
	println(pdfDescargado)
	println(verificarExistePDF)
	assert verificarExistePDF == true
}
else {
	WebUI.delay(1)
	//Se verifica que el archivo se haya descargado correctamente
	assert verificarExistePDF == true
	WebUI.delay(3)
}

/**
 * Exportar en EXCEL
 */
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonExportarFinal'))
WebUI.delay(8)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonExportarExcel'))
WebUI.delay(8)

//Esta parte se hace debido a que el archivo exportado tiene en el nombre la fecha y hora actual
println(LocalDateTime.now().plusHours(2))
//Se obtiene la fecha actual con la hora y se le suman dos hora, debido a que el reporte sale con la hora de Uruguay
def String fechaSinFormatoEXCEL = LocalDateTime.now().plusHours(2)
//Sacamos la fecha aparte
String fechaEXCEL = fechaSinFormatoEXCEL.substring(0, 10)
//Se le cambia el guion por vacio
fechaEXCEL = fechaEXCEL.replace('-', '')

//Sacamos la hora aparte
String horaEXCEL = fechaSinFormatoEXCEL.substring(11, 16)
//Se le cambia el guion por vacio
horaEXCEL = horaEXCEL.replace(':', '')

//Se convierte la variable de la hora a Int para usarla mas adelante, y poder sumarle 1 minuto en caso de ser necesario
def int EXCELHora = Integer.parseInt(horaEXCEL)
WebUI.delay(2)

//se crea un objeto de tipo File y se le pasa la ruta donde debe existir el archivo descargado
File EXCELDescargado = new File("C:\\Users\\marr801550\\Downloads\\PlanDeCuentas_"+fechaEXCEL+'_'+EXCELHora+".xlsx");
WebUI.delay(2)
println(EXCELDescargado)

//Se crea una variable y se usa el metodo exist() de la clase File, para validar si encontró o no el archivo en la ruta
def verificarExisteEXCEL = EXCELDescargado.exists();
println(verificarExisteEXCEL)

//Creamos un condicional por si al momento de descargar el archivo el nombre cambia a raiz de un cambio en la hora
//Le sumamos un minuto para que valide nuevamente el nombre del archivo
if(verificarExisteEXCEL == false) {
	EXCELHora = EXCELHora + 1//sumamos un minuto
	println(EXCELHora)
	EXCELDescargado = new File("C:\\Users\\marr801550\\Downloads\\PlanDeCuentas_"+fechaEXCEL+'_'+EXCELHora+".xlsx");
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
/**
 * Exportar en WORD
 */
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonExportarFinal'))
WebUI.delay(8)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonExportarWord'))
WebUI.delay(8)

//Esta parte se hace debido a que el archivo exportado tiene en el nombre la fecha y hora actual
println(LocalDateTime.now().plusHours(2))
//Se obtiene la fecha actual con la hora y se le suman dos hora, debido a que el reporte sale con la hora de Uruguay
def String fechaSinFormatoWORD = LocalDateTime.now().plusHours(2)
//Sacamos la fecha aparte
String fechaWORD = fechaSinFormatoWORD.substring(0, 10)
//Se le cambia el guion por vacio
fechaWORD = fechaWORD.replace('-', '')

//Sacamos la hora aparte
String horaWORD = fechaSinFormatoWORD.substring(11, 16)
//Se le cambia el guion por vacio
horaWORD = horaWORD.replace(':', '')

//Se convierte la variable de la hora a Int para usarla mas adelante, y poder sumarle 1 minuto en caso de ser necesario
def int WORDHora = Integer.parseInt(horaWORD)
WebUI.delay(2)

//se crea un objeto de tipo File y se le pasa la ruta donde debe existir el archivo descargado
File WORDDescargado = new File("C:\\Users\\marr801550\\Downloads\\PlanDeCuentas_"+fechaWORD+'_'+WORDHora+".docx");
println(WORDDescargado)
WebUI.delay(2)

//Se crea una variable y se usa el metodo exist() de la clase File, para validar si encontró o no el archivo en la ruta
def verificarExisteWORD = WORDDescargado.exists();
println(verificarExisteWORD)

WebUI.delay(3)
//Creamos un condicional por si al momento de descargar el archivo el nombre cambia a raiz de un cambio en la hora
//Le sumamos un minuto para que valide nuevamente el nombre del archivo
if(verificarExisteWORD == false) {
	WORDHora = WORDHora + 1//sumamos un minuto
	println(WORDHora)
	WORDDescargado = new File("C:\\Users\\marr801550\\Downloads\\PlanDeCuentas_"+fechaWORD+'_'+WORDHora+".docx");
	println(WORDDescargado)
	println(verificarExisteWORD)
	verificarExisteWORD = WORDDescargado.exists()
	assert verificarExisteWORD == true
}
else {
	WebUI.delay(1)
	//Se verifica que el archivo se haya descargado correctamente
	assert verificarExisteWORD == true
	WebUI.delay(3)
}
WebUI.executeJavaScript("alert('******** AQUI TERMINA EL TEST ********')", null)
WebUI.delay(3)
WebUI.closeBrowser()
