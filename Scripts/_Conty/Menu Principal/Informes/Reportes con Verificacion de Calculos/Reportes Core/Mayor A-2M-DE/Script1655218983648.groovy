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
import java.lang.Float as Float

/**
 * Fecha creacion : 23-05-2022
 * QA : Santiago Marrugo
 */

//Tipo de mayor
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/DDTipoDeMayor'), '1', false)
WebUI.delay(1)
//Fecha inicial
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaInicial'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaInicial'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaInicial'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaInicial'), '01/01/2022')
WebUI.delay(1)
//Fecha final
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaFinal'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaFinal'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaFinal'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaFinal'), '31/01/2022')
WebUI.delay(1)
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/FechaInicial'))
WebUI.delay(1)
//Importes en dos monedas
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/DDImportesEn'), '2', false)
WebUI.delay(1)
//Moneda uno en dolares
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/DDMonedaUno'), '2', false)
WebUI.delay(1)
//Moneda dos en euros
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/DDMonedaDos'), '9', false)
WebUI.delay(1)
//Apertura
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/DDApertura'), '0', false)
WebUI.delay(1)
//Generamos el reporte
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Mayores/BotonAceptarPopupMayores'))
WebUI.delay(15)

//Verificamos la generacion del reporte
def String tituloReporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelTituloReporte-Mayor-A-2M-DE'))
println(tituloReporte)
assert tituloReporte == 'Mayor analítico'

def String periodoReporte = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelPeriodoReporte-Mayor A-2M-DE'))
println(periodoReporte)
assert periodoReporte == '01/01/2022 a 31/01/2022. US$ y €'
WebUI.delay(1)

//Se verifica las fechas de los asientos
def String diaLinea1 = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/DiaLinea1MayorA2MDE'))
println(diaLinea1)
def String diaLinea2 = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/DiaLinea2MayorA2MDE'))
println(diaLinea2)
def String diaLinea3 = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/DiaLinea3MayorA2MDE'))
println(diaLinea3)

assert diaLinea1 == '05/01/2022' && diaLinea2 == '05/01/2022' && diaLinea3 == '05/01/2022'

//Verificamos los valores del reporte en dolares y euros
//Encabezados de las columnas en dolares y euros
def String lblDebeUSD = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelDebeUSD'))
def String lblHaberUSD = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelHaberUSD'))
def String lblSaldoUSD = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelSaldoUSD'))

def String lblDebeEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelDebeEUR'))
def String lblHaberEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelHaberEUR'))
def String lblSaldoEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/LabelSaldoEUR'))
assert (lblDebeUSD == 'Debe US$' && lblHaberUSD == 'Haber US$' && lblSaldoUSD == 'Saldo US$' 
&& lblDebeEUR == 'Debe €' && lblHaberEUR == 'Haber €' && lblSaldoEUR == 'Saldo €')

//Linea 1
println('---Linea 1---')
def String valorL1DebeUSD = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL1DebeUSD-MA'))
def String valorL1SaldoUSD = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL1SaldoUSD-MA'))
def String valorL1DebeEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL1DebeEUR-MA'))
def String valorL1SaldoEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL1SaldoEUR-MA'))
assert valorL1DebeUSD == '348.80' && valorL1SaldoUSD == '348.80' && valorL1DebeEUR == '309.23' && valorL1SaldoEUR == '309.23'

//linea 2
println('---Linea 2---')
def String valorL2HaberUSD = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL2HaberUSD-MA'))
def String valorL2SaldoUSD = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL2SaldoUSD-MA'))
def String valorL2HaberEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL2HaberEUR-MA'))
def String valorL2SaldoEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL2SaldoEUR-MA'))
assert valorL2HaberUSD == '62.83' && valorL2SaldoUSD == '-62.83' && valorL2HaberEUR == '55.70' && valorL2SaldoEUR == '-55.70'

//linea 3
println('---Linea 3---')
def String valorL3HaberUSD = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL3HaberUSD-MA'))
def String valorL3SaldoUSD = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL3SaldoUSD-MA'))
def String valorL3HaberEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL3HaberEUR-MA'))
def String valorL3SaldoEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorL3SaldoEUR-MA'))
assert valorL3HaberUSD == '285.97' && valorL3SaldoUSD == '-285.97' && valorL3HaberEUR == '253.53' && valorL3SaldoEUR == '-253.53'

//Total debitos
println('---Total debitos---')
def String totalDebUSD = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorTotalDebitosUSD'))
def String totalDebEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorTotalDebitosEUR'))
assert totalDebUSD == '348.80' && totalDebEUR == '309.23'

//Total creditos
println('---Total creditos---')
def String totalCreUSD = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorTotalCreditosUSD'))
def String totalCreEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorTotalCreditosEUR'))
assert totalCreUSD == '348.80' && totalCreEUR == '309.23'

//Total saldo deudores
println('---Total saldo deudores---')
def String totalSalDeudoresUSD = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorTotalSaldoDeuUSD'))
def String totalSalDeudoresEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorTotalSaldoDeuEUR'))
assert totalSalDeudoresUSD == '348.80' && totalSalDeudoresEUR == '309.23'

//Total saldo acreedores
println('---Total saldo acreedores---')
def String totalSalAcreedoresUSD = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorTotalSaldoAcreeUSD'))
def String totalSalAcreedoresEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ValorTotalSaldoAcreeEUR'))
assert totalSalAcreedoresUSD == '348.80' && totalSalAcreedoresEUR == '309.23'

//Saldo deudores menos acreedores
def String resultadoDeuAcreUSD = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ResultadoDeuAcreeUSD'))
println(resultadoDeuAcreUSD)
def String resultadoDeuAcreEUR = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Informes/Reportes con Verificacion de Calculos/ResultadoDeuAcreeEUR'))
println(resultadoDeuAcreEUR)

//Dolares
//Convertimos los valores a float
def float saldoDeudoresUSD = Float.parseFloat(totalSalDeudoresUSD)//348.80
def float saldoAcreedoresUSD = Float.parseFloat(totalSalAcreedoresUSD)//348.80
def float resultadoUSD = Float.parseFloat(resultadoDeuAcreUSD)//0.00

//Hacemos la resta de los valores y se guardan en una variable float y despues se compara con el resultado de los saldos de deudores menos el saldo de acreedores
def float restaUSD = saldoDeudoresUSD - saldoAcreedoresUSD
println(restaUSD)//0.00
println(resultadoUSD)//0.00
assert resultadoUSD == restaUSD

//Euros
//Convertimos los valores a float
def float saldoDeudoresEUR = Float.parseFloat(totalSalDeudoresEUR)//309.23
def float saldoAcreedoresEUR = Float.parseFloat(totalSalAcreedoresEUR)//309.23
def float resultadoEUR = Float.parseFloat(resultadoDeuAcreEUR)//0.00

//Hacemos la resta de los valores y se guardan en una variable float y despues se compara con el resultado de los saldos de deudores menos el saldo de acreedores
def float restaEUR = saldoDeudoresEUR - saldoAcreedoresEUR
println(restaEUR)//0.00
println(resultadoEUR)//0.00
assert resultadoEUR == restaEUR

