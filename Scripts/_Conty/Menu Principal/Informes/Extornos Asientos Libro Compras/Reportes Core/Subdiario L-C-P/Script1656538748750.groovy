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

/**
 * Fecha creacion : 29-06-2022
 * QA : Santiago Marrugo
 */

//Seleccionamos el libro
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/DDLibro'), '1', false)
WebUI.delay(1)
//Las fechas
//Inicial
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaInicial'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaInicial'), Keys.chord(Keys.CONTROL, 'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaInicial'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaInicial'), '01/02/2022')
WebUI.delay(1)
//Final
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaFinal'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaFinal'), Keys.chord(Keys.CONTROL, 'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaFinal'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaFinal'), '28/02/2022')
WebUI.delay(1)
//Ubicamos el foco nuevamente en la fecha inicial para que se active el boton Aceptar
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/FechaInicial'))
//La moneda
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/DDMoneda'), '1', false)
WebUI.delay(1)
//Apertura
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/DDApertura'), '0', false)
WebUI.delay(1)
//Generamos el reporte
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Subdiarios/BotonAceptarPopupSubdiarios'))
WebUI.delay(10)

//Verificamos que se haya generado sin tener en cuenta los valores del Reporte
def String tituloReporte = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Subdiario/LabelTituloReporte-Subdiario L-C-P'))
println(tituloReporte)
assert tituloReporte == 'Libro de Compras'
WebUI.delay(1)

def String periodoReporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Subdiario/LabelPeriodoReporte-Subdiario L-C-P'))
println(periodoReporte)
assert periodoReporte == '01/02/2022 a 28/02/2022 en $'
WebUI.delay(1)

WebUI.verifyTextPresent('Monto $', false)
WebUI.delay(1)

//Validamos las fechas de los asientos en el reporte
def String linea1 = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Subdiario/FechaLinea1-Subdiario L-C-P'))
println(linea1)
def String linea2 = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Subdiario/FechaLinea2-Subdiario L-C-P'))
println(linea2)
def String linea3 = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Subdiario/FechaLinea3-Subdiario L-C-P'))
println(linea3)
def String linea4 = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Subdiario/FechaLinea4-Subdiario L-C-P'))
println(linea4)
def String linea5 = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Subdiario/FechaLinea5-Subdiario L-C-P'))
println(linea5)
def String linea6 = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Subdiario/FechaLinea6-Subdiario L-C-P'))
println(linea6)
assert linea1 == '05/02/22' && linea2 == '05/02/22' && linea3 == '08/02/22' && linea4 == '08/02/22' && linea5 == '09/02/22' && linea6 == '10/02/22'

//Validamos los valores al final del reporte
def String exentoMontoPesos = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Subdiario/exentoMontoPesos'))
println(exentoMontoPesos)
def String exentoIVAPesos = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Subdiario/exentoIVAPesos'))
println(exentoIVAPesos)
def String exentoTotalPesos = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Subdiario/exentoTotalPesos'))
println(exentoTotalPesos)

def String ivaTasaMinimaMontoPesos = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Subdiario/ivaTasaMinimaMontoPesos'))
println(ivaTasaMinimaMontoPesos)
def String ivaTasaMinimaIVAPesos = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Subdiario/ivaTasaMinimaIVAPesos'))
println(ivaTasaMinimaIVAPesos)
def String ivaTasaMinimaTotalPesos = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Subdiario/ivaTasaMinimaTotalPesos'))
println(ivaTasaMinimaTotalPesos)

def String ivaTasaBasicaMontoPesos = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Subdiario/ivaTasaBasicaMontoPesos'))
println(ivaTasaBasicaMontoPesos)
def String ivaTasaBasicaIVAPesos = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Subdiario/ivaTasaBasicaIVAPesos'))
println(ivaTasaBasicaIVAPesos)
def String ivaTasaBasicaTotalPesos = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Subdiario/ivaTasaBasicaTotalPesos'))
println(ivaTasaBasicaTotalPesos)

def String totalGeneralMontoPesos = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Subdiario/totalGeneralMontoPesos'))
println(totalGeneralMontoPesos)
def String totalGeneralIVAPesos = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Subdiario/totalGeneralIVAPesos'))
println(totalGeneralIVAPesos)
def String totalGeneralTotalPesos = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Extornos Asientos Libro Compras/Subdiario/totalGeneralTotalPesos'))
println(totalGeneralTotalPesos)

assert (exentoMontoPesos == '0.00' && exentoIVAPesos == '0.00' && exentoTotalPesos == '0.00' && ivaTasaMinimaMontoPesos == '3,818.18' && ivaTasaMinimaIVAPesos == '381.82' 
&& ivaTasaMinimaTotalPesos == '4,200.00' && ivaTasaBasicaMontoPesos == '1,229.51' && ivaTasaBasicaIVAPesos == '270.49' && ivaTasaBasicaTotalPesos == '1,500.00' 
&& totalGeneralMontoPesos == '5,047.69' && totalGeneralIVAPesos == '652.31' && totalGeneralTotalPesos == '5,700.00' )

