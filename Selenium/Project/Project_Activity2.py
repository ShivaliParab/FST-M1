# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

url = 'http://alchemy.hguy.co/orangehrm'
expected_url = 'http://example.com'


# Set up the Firefox Driver with WebDriverManger
def get_website_title(url):
    service = FirefoxService(GeckoDriverManager().install())
    with webdriver.Firefox(service=service) as driver:
        driver.get(url)
        title = driver.title
        print("Page title is:", title)
        assert url == expected_url, f"URL mismatch: Expected {expected_url}, but got {url}"

def teardown():
    driver.quit()


get_website_title(url)
teardown()
