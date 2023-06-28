from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

url = 'http://alchemy.hguy.co/orangehrm'
expected_url = 'http://example.com'

def get_website_title(url):
    service = FirefoxService(GeckoDriverManager().install())
    with webdriver.Firefox(service=service) as driver:
        driver.get(url)
        title = driver.title
        return title

def getimage():
    driver = webdriver.Firefox(service=FirefoxService(executable_path=GeckoDriverManager().install()))
    title = get_website_title(url)
    print("Page title is:", title)
    driver.get(url)
    driver.find_element(By.ID, 'txtUsername').send_keys("orange")
    driver.find_element(By.ID, 'txtPassword').send_keys("orangepassword123")
    driver.find_element(By.ID, 'btnLogin').click()
    welcomemsg = driver.find_element(By.ID, "welcome")
    print("Image message:",welcomemsg.text)
    driver.quit()

getimage()
