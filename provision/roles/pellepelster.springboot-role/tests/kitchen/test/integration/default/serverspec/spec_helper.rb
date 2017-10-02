require 'serverspec'
require 'busser/rubygems'

set :backend, :exec

Busser::RubyGems.install_gem('faraday', '~> 0.9.0')
require 'faraday'

RSpec.configure do |c|
  c.before :all do
    c.path = '/sbin:/usr/sbin'
  end
end
