#Implementation of Selenium test automation for this Selenium Python Tutorial
from selenium import webdriver
import sys
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.keys import Keys
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from time import sleep


def test_lambdatest_todo_app():
    chrome_driver = webdriver.Chrome('C:/Program Files/Google/Chrome/Application/chromedriver.exe')
    # chrome_driver = webdriver.Chrome(ChromeDriverManager().install())
    chrome_driver.get('url')
    chrome_driver.maximize_window()

    #Disclamer
    chrome_driver.find_element(By.XPATH, "// button[contains(text(),'Yes')]").click()

    #Agree Cookies
    chrome_driver.find_element(By.XPATH, "// button[contains(text(),'I Agree')]").click()

    #Login/Register
    chrome_driver.find_element(By.XPATH, "// span[contains(text(),'Login / Register')]").click()
    

    #Enter email id
    email_id = "email@gmail.com"
    signin_email = chrome_driver.find_element(By.ID, "email")
    signin_email.send_keys(email_id)

    # Sign in
    chrome_driver.find_element(By.XPATH, "// span[contains(text(),'Next')]").click()

    # Check error
    error = ''
    error = WebDriverWait(chrome_driver,10).until(EC.presence_of_element_located((By.CSS_SELECTOR,"div.lds-toast-content"))).text
    print("Error ->",error)
    if error:
        #Taking screenshot
        chrome_driver.save_screenshot("./screenshots/signin-error.png")

        #Creating account
        chrome_driver.find_element(By.XPATH, "// a[contains(text(),'Create account')]").click()

        sleep(2)

        # Entering email id
        chrome_driver.find_element(By.XPATH, "// span[contains(text(),'Next')]").click()

        sleep(3)

        # NPI no.
        chrome_driver.find_element(By.XPATH, "// span[contains(text(),'Next')]").click()

    else:
        print("No error")
        assert False
    
    sleep(2)
    chrome_driver.close()
