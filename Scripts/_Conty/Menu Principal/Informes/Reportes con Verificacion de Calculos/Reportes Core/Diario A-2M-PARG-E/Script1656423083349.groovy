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
import java.text.DecimalFormat

/**
 * Fecha creacion : 28-06-2022
 * QA : Santiago Marrugo
 */

//Seleccionamos el tipo de diario
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/DDTipoDiario'), '1', false)
WebUI.delay(1)
//Fecha inicial
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/FechaInicial'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/FechaInicial'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/FechaInicial'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/FechaInicial'), '01/01/2022')
WebUI.delay(1)
//Fecha final
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/FechaFinal'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/FechaFinal'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/FechaFinal'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/FechaFinal'), '31/01/2022')
WebUI.delay(1)
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/FechaInicial'))
WebUI.delay(1)
//Importes en dos monedas
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/DDImportesEn'), '2', false)
WebUI.delay(1)
//Moneda uno pesos argentinos
WebUI.selectOptionByValue(findTestObject('_Conty/Menu Principal/Informes/Diarios/DDMonedaUno'), '3', false)
WebUI.delay(1)
//Moneda dos euros
WebUI.selectOptionByValue(findTestObject('_Conty/Menu Principal/Informes/Diarios/DDMonedaDos'), '9', false)
WebUI.delay(1)
//Apertura
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/DDApertura'), '0', false)
WebUI.delay(1)
//Orden
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/DDOrden'), '0', false)
WebUI.delay(1)
//Generamos el reporte
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Diarios/BotonAceptarPopupDiarios'), FailureHandling.STOP_ON_FAILURE)
WebUI.delay(8)

//Verificamos que el reporte se haya generado
def String tituloReporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelTituloReporte-Diario-A-2M-PARG-E'))
println(tituloReporte)
assert tituloReporte == 'Diario analítico'

def String periodoReporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelPeriodoReporte Diario A-2M-PARG-E'))
println(periodoReporte)
assert periodoReporte == '01/01/2022 a 31/01/2022. $AR y €'

//Verificamos la primer linea del reporte por el concepto de Transporte
def String labelTransporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelTransporteDiario A-2M-PARG-E'))
println(labelTransporte)
assert labelTransporte == 'Transporte'

//Verificamos los ceros en cada una de las columnas del debe y haber en las dos monedas
def String debePARG = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorDebePARG Diario A-2M-PARG-E'))
println(debePARG)
assert debePARG == '0.00'
def String haberPARG = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorHaberPARG Diario A-2M-PARG-E'))
println(haberPARG)
assert haberPARG == '0.00'
def String debeEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorDebeEUR Diario A-2M-PARG-E'))
println(debeEUR)
assert debeEUR == '0.00'
def String haberEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorHaberEUR - Diario A-2M-PARG-E'))
println(haberEUR)
assert haberEUR == '0.00'

//Fecha de los asientos
WebUI.verifyTextPresent('11/01/2022', false)

//Verificamos los valores de los 3 asientos
//Valores de la primera linea
def String linea1DebePARG = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL1DebePARG Diario A-2M-PARG-E'))
println(linea1DebePARG)
/**
 * El valor correcto para (linea1DebePARG) este valor es 1,614,577.05 se reporta BUG # 248578
 */
assert linea1DebePARG == '1,614,565.68'
def String linea1DebeEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL1DebeEUR Diario A-2M-PARG-E'))
println(linea1DebeEUR)
assert linea1DebeEUR == '13,777.88'

//Valores de la segunda linea
def String linea2HaberPARG = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL2HaberPARG Diario A-2M-PARG-E'))
println(linea2HaberPARG)
/**
  * El valor correcto para (linea2HaberPARG) este valor es 1,323,746.18 se reporta BUG # 248578
  */
assert linea2HaberPARG == '1,323,736.86'
def String linea2HaberEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL2HaberEUR Diario A-2M-PARG-E'))
println(linea2HaberEUR)
assert linea2HaberEUR == '11,296.09'

//Valores de la tercera linea
def String linea3HaberPARG = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL3HaberPARG Diario 2M-PARG-E'))
println(linea3HaberPARG)
/**
   * El valor correcto para (linea3HaberPARG) este valor es 290,830.87 se reporta BUG # 248578
   */
assert linea3HaberPARG == '290,828.82'
def String linea3HaberEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL3HaberEUR Diario 2M-PARG-E'))
println(linea3HaberEUR)
assert linea3HaberEUR == '2,481.78'

//Validar linea de los totales
def String lineaTotalDebePARG = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/TotalDebePARG Diario A-2M-PARG-E'))
println(lineaTotalDebePARG)
/**
 * El valor correcto para (lineaTotalDebePARG) este valor es 1,614,577.05 se reporta BUG # 248578
 */
assert lineaTotalDebePARG == '1,614,565.68'

def String lineaTotalHaberPARG = WebUI.getText(findTestObject('_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/TotalHaberPARG Diario A 2M-PARG-E'))
println(lineaTotalHaberPARG)
/**
 * El valor correcto para (lineaTotalHaberPARG ) este valor es 1,614,577.05 se reporta BUG # 248578
 */
assert lineaTotalHaberPARG == '1,614,565.68'

def String lineaTotalDebeEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/TotalDebeEUR Diario A-2M-PARG-E'))
println(lineaTotalDebeEUR)
assert lineaTotalDebeEUR == '13,777.88'

def String lineaTotalHaberEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/TotalHaberEUR Diario A-2M-PARG-E'))
println(lineaTotalHaberEUR)
assert lineaTotalHaberEUR == '13,777.87'


