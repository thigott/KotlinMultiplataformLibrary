Pod::Spec.new do |spec|
  spec.name = 'KotlinMultiplatformFlavor'
  spec.version = '2.0.0'
  spec.homepage = 'https://github.com/thigott/KotlinMultiplataformLibrary'
  spec.source = { :git => "https://github.com/thigott/KotlinMultiplataformLibrary", :tag => "2.0.0" }
  spec.authors = 'Thiago Gottardo Alves'
 spec.license = { :type => "MIT", :file => "LICENSE" }
  spec.summary = 'An KMM Libray Example'
  spec.static_framework = true
  spec.vendored_frameworks = "KotlinMultiplatformFlavor.framework"
  spec.libraries = "c++"
  spec.module_name = "#{spec.name}_umbrella"
  spec.ios.deployment_target = '14.1'
end
