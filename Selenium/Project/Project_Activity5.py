from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import Select
def setup_driver():
    # Set up WebDriver
    driver = webdriver.Firefox()
    wait = WebDriverWait(driver, 10)
    return driver, wait

def login(driver, wait):
    # Open the website
    driver.get("http://alchemy.hguy.co/orangehrm")

    # Login
    username = wait.until(EC.presence_of_element_located((By.ID, "txtUsername")))
    password = wait.until(EC.presence_of_element_located((By.ID, "txtPassword")))
    login_btn = wait.until(EC.element_to_be_clickable((By.ID, "btnLogin")))

    username.send_keys("orange")
    password.send_keys("orangepassword123")
    login_btn.click()
def my_info(driver):
    view_det = wait.until(EC.element_to_be_clickable((By.XPATH, "//a[@id='menu_pim_viewMyDetails']")))
    view_det.click()
    view_det.click()
    edit_emp = driver.find_element(By.ID, "btnSave")
    edit_emp.click()
    emp_full_name = driver.find_element(By.ID, "personal_txtEmpFirstName")
    emp_full_name.clear()
    emp_full_name.send_keys("orange")
    gender = driver.find_element(By.ID, "personal_optGender_2")
    gender.click()
    print("gender select")
    nationality = Select(driver.find_element(By.ID, "personal_cmbNation"))
    nationality.select_by_visible_text("Indian")
    edit_btn = driver.find_element(By.XPATH, "//input[@value='Save']")
    edit_btn.click()

def close_browser(driver):
    # Close the browser
    driver.quit()

# Call the functions to execute the setup, login, and browser closure
driver, wait = setup_driver()
login(driver, wait)
my_info(driver)
close_browser(driver)
