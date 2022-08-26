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
import internal.GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.io.File
import java.time.LocalDateTime
import java.time.ZoneId
import java.nio.file.*
import java.io.IOException;
import com.kms.katalon.core.util.KeywordUtil as KWU

/**
 * Fecha creacion : 11-08-2022
 * QA : Santiago Marrugo
 */

//Ingresamos a la opción Monedas
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Accesos a menu principal/Acceso a Configurar Monedas'), null)
WebUI.delay(0.5)

KWU.logInfo("--- ID 27, 28, 29 y 30 ---")
//Nos vamos a imprimir el listado de monedas
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Configuracion/Monedas/BotonImprimir'))
WebUI.delay(20)
WebUI.verifyTextPresent('Monedas', false)
WebUI.verifyElementPresent(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Configuracion/Monedas/LabelReporteMonedas_2'), 2)

WebUI.delay(0.5)

//Nos posicionamos en el Top de la pagina
WebUI.scrollToPosition(0, 0)
//Procedemos a exportar en PDF
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Configuracion/Monedas/BotonExportarMonedas'))
WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Configuracion/Monedas/BotonExportarMonedasPDF'))
WebUI.delay(10)
//Instanciamos un Objeto de la clase File y le pasamos la ruta de la carpeta de las descargas
File pdfDescargado = new File("C:\\Users\\marr801550\\Downloads\\EmpresaMoneda.pdf")
def existePdf = pdfDescargado.exists()
assert existePdf == true

//Procedemos a exportar en Excel
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Configuracion/Monedas/BotonExportarMonedas'))
WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Configuracion/Monedas/BotonExportarMonedasExcel'))
WebUI.delay(10)
//Instanciamos un Objeto de la clase File y le pasamos la ruta de la carpeta de las descargas
File excelDescargado = new File("C:\\Users\\marr801550\\Downloads\\EmpresaMoneda.xlsx")
def existeExcel = excelDescargado.exists()
assert existeExcel == true

//Procedemos a exportar en Word
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Configuracion/Monedas/BotonExportarMonedas'))
WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Configuracion/Monedas/BotonExportarMonedasWord'))
WebUI.delay(10)
//Instanciamos un Objeto de la clase File y le pasamos la ruta de la carpeta de las descargas
File wordDescargado = new File("C:\\Users\\marr801550\\Downloads\\EmpresaMoneda.docx")
def existeWord = wordDescargado.exists()
assert existeWord == true

//Eliminamos los archivos descargados, para efectos de la regresion
Path pathPdf = Paths.get("C:\\Users\\marr801550\\Downloads\\EmpresaMoneda.pdf")
Files.delete(pathPdf)

Path pathExcel = Paths.get("C:\\Users\\marr801550\\Downloads\\EmpresaMoneda.xlsx")
Files.delete(pathExcel)

Path pathWord = Paths.get("C:\\Users\\marr801550\\Downloads\\EmpresaMoneda.docx")
Files.delete(pathWord)
WebUI.delay(1)

//Fin del test
KWU.markPassed("Test terminado con éxito")
WebUI.closeBrowser()