
# Requirements
terraform {
  required_version = ">= 0.12"
}

# Variables
variable "access_key" {
  default = ""
}

variable "secret_key" {
  default = ""
}

variable "region" {
  default = ""
}

# AWS Provider
provider "aws" {
  access_key  = var.access_key
  secret_key  = var.secret_key
  region      = var.region
