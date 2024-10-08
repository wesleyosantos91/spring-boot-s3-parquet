#!/bin/bash

# Configuration Environment Variables
AWS_ACCESS_KEY_ID="default_access_key"
AWS_SECRET_ACCESS_KEY="default_secret_key"
AWS_REGION="us-east-1"
AWS_PROFILE="localstack-profile"

# Created profile localstack-profile
aws configure --profile $AWS_PROFILE set aws_access_key_id $AWS_ACCESS_KEY_ID
aws configure --profile $AWS_PROFILE set aws_secret_access_key $AWS_SECRET_ACCESS_KEY
aws configure --profile $AWS_PROFILE set region $AWS_REGION

# List Profiles created
aws configure list --profile $AWS_PROFILE